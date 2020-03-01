/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supertrunfogamereciclagem;
import java.util.Scanner;
import baralho.Baralho;
import baralho.FilaBaralho;
//import com.sun.java_cup.internal.runtime.Scanner;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author darle
 */
public class SuperTrunfoGameReciclagem extends JFrame implements ActionListener{

    /**
     * @param args the command line arguments
     */
    PainelDadosJogo dados ;
    PainelGame painelGame;
    PainelPegaOpcaoEquemGanha painelEsc;
    JPanel painelPrincipal;
    public SuperTrunfoGameReciclagem() 
    {
    	// Definicoes originais da Classe Game
   
        initGUI();
    }
    
    public void initGUI() {
    	// Caracteristicas da Janela Principal ############################################
        setTitle("Super Trunfo Game");
        setSize(1724, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(1,0));
        setBackground(new Color(200, 20, 200));
        
        
        // Construcao do painel principal #############################
        //*
        
        
        painelPrincipal = new JPanel(); 
        
        painelPrincipal.setBackground(new Color(200, 20, 200));
        painelPrincipal.setBackground(new Color(255, 255, 0));
        painelPrincipal.setBorder(BorderFactory.createLineBorder(new Color(200, 20, 200), 10));
        painelPrincipal.setSize(1024, 720);
        painelPrincipal.setLayout(new BorderLayout());
        painelPrincipal.setVisible(true);        
         
        //CRiando painel dos Botoes
        JPanel painelDosBotoes = new JPanel();
        painelDosBotoes.setLayout(new GridLayout(0, 5));
        painelDosBotoes.add(new PainelCor());
        //adcionando painel dos botoes ao painel principal        
        painelDosBotoes.add(new PainelCor());
        painelDosBotoes.add(preparaBotaoIniciarJogo());
        painelDosBotoes.add(preparaBotaoSair());
        painelDosBotoes.add(new PainelCor());
        
       //Adcionado o paineldos botoes no sul
        painelGame = new PainelGame();
        painelPrincipal.add(painelGame.RetornaTitulo(),BorderLayout.NORTH);
        
        
        painelPrincipal.add(painelDosBotoes,BorderLayout.SOUTH);
        
        //adcionado a imagem do jogo no centro
        painelPrincipal.add(painelGame,BorderLayout.CENTER);
        
        //adcionadndo painelGame que é o titulo no topo
        dados = new PainelDadosJogo();
        painelPrincipal.add(dados,BorderLayout.WEST);
        //painelPrincipal.add()
        add(painelPrincipal);
    }
    private JButton preparaBotaoSair() {
      JButton botaoSair = new JButton("Sair");
      botaoSair.setBounds(100, 20, 1000, 1000);
         
      botaoSair.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          System.exit(0);
        }
      });
      
      return botaoSair;
    }
    private JButton preparaBotaoIniciarJogo() {
        JButton botaoNovoJogo = new JButton("Iniciar Jogo");
        
        botaoNovoJogo.setBounds(100, 20, 1000, 1000);
        //*/Quando o Botão iniciar Jogo é Precionado inicia uma nova partida
        botaoNovoJogo.addActionListener(new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e) {
                if(painelGame.retornaJogadores().isEmpty())
                    novoJogo();
                else
                    JOptionPane.showMessageDialog(null,"Jogo em andamento!");
            }
        });//*/
    
        return botaoNovoJogo;
    }
    public void novoJogo(){        

        try {
            String pegaNome;
            
            int numeroDeJogadores = 0;
            while (numeroDeJogadores == 0) {                
                try {
                    numeroDeJogadores = Integer.parseInt(JOptionPane.showInputDialog("Este jogo necessita de 2 a 4 players.Digite quantos irão jogar:"));
                    if(numeroDeJogadores < 2 || numeroDeJogadores > 4){
                        JOptionPane.showMessageDialog(null,"Digite um numero Válido!"); 
                        numeroDeJogadores = 0;
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"Digite um numero Válido!"); 
                    numeroDeJogadores = 0;
                }
            }           
            
            Baralho meuBaralho = new Baralho();            
            
            for (int i = 0; i < numeroDeJogadores; i++) {

                pegaNome = JOptionPane.showInputDialog("Digite o nome do jogador: " + (i+1));

                dados.atualizarNomeJogador(i, pegaNome);
                painelGame.addJogador(i, pegaNome);

                for (int j = 0; j < meuBaralho.baralhoSize()/numeroDeJogadores; j++) {                            
                    painelGame.setCartaGridJogador(i, meuBaralho.atualBaralho().removeRand());
                }
                dados.atualizarCartasNaMaoJogador(i, painelGame.retornaCartasNaMao(i));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            //System.out.println("Erro");
        }
        painelEsc = new PainelPegaOpcaoEquemGanha();
        painelPrincipal.add(painelEsc,BorderLayout.EAST);

        ThreadGame  jogando = new ThreadGame(painelGame.retornaJogadores().size());
        jogando.start();
    }
                
                
    public class ThreadGame extends Thread {
        int jogadorDaVez;
        int numeroDeJogadores;
        int venceu;
        int opcao;
        FilaBaralho cartasEmpate = new FilaBaralho();      
         
        public ThreadGame(int numeroDeJogadores) {
            this.numeroDeJogadores = painelGame.retornaJogadores().size();
            jogadorDaVez = 0;
            venceu = 0;
        }
        
         @Override
         public void run(){
                    
                    
            try {
                while(venceu >= 0){  //quando a funcao retornar um valor negativo, o jogo acaba
                   //vira carta
                    painelGame.mostraCartaJogadorDavez(jogadorDaVez);
                    painelEsc.atualizarNome(painelGame.getJogador(jogadorDaVez).getNomeJogador());
                    painelGame.revalidate();
                    painelGame.repaint();
                    
                    while(painelEsc.getOpcao().equals("")){

                       Thread.sleep(500);
                       try {
                            if(Integer.parseInt(painelEsc.getOpcao()) > 0 && Integer.parseInt(painelEsc.getOpcao()) <= 4){
                                opcao = Integer.parseInt(painelEsc.getOpcao());
                            }else{
                                painelEsc.setOpcao();
                            }
                        } catch (Exception e) {
                           painelEsc.setOpcao();
                        }
                    }

                    for (int i = 0; i < painelGame.retornaJogadores().size(); i++) {
                        if(jogadorDaVez != i){
                            painelGame.mostraCartaJogadorDavez(i);
                        }
                    }
                    painelGame.revalidate();
                    painelGame.repaint();
                    //Valor Coletado

                    /*
                    *Lógica do game aqui, ler atributo escolhido
                    */
                    venceu = dizQuemVence(jogadorDaVez,opcao,cartasEmpate);
                    
                    /*
                    *Vira todas as cartas de cabeça para baixo de novo
                    */
                    for (int i = 0; i < painelGame.retornaJogadores().size(); i++) {
                        painelGame.getJogador(i).setImagemCartaVirada();                      
                    }
                    painelGame.revalidate();
                    painelGame.repaint();
                    
                    jogadorDaVez = venceu;
                    
                    /*
                    *Seta o valor do comparador do while de espera para ""
                    */
                    painelEsc.setOpcao();
                }
            JOptionPane.showMessageDialog(null,"Parabéns Jogador " + painelGame.getJogador(0).getNomeJogador() + ", Você é o vencedor!"); 
            } catch (InterruptedException ex) {
               System.err.println(ex.getMessage());
               Logger.getLogger(SuperTrunfoGameReciclagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public int dizQuemVence(int jogadorDaVez,int opcao,FilaBaralho cartasEmpate){
        
        int indiceGanhando;
        boolean empate = false;                

        switch (opcao) {
            case 1:     //Testa a cor que ganha
                indiceGanhando = jogadorDaVez;
                for (int j = 0; j < painelGame.retornaJogadores().size(); j++) {
                    if(jogadorDaVez != j){                       
                        if(painelGame.getJogador(indiceGanhando).retornaCartaQueJoga().getCor().equals(painelGame.getJogador(j).retornaCartaQueJoga().getCor())){
                               empate = true;                                                               
                        }
                        else if(!painelGame.getJogador(indiceGanhando).retornaCartaQueJoga().ganhaDeQualCor(painelGame.getJogador(j).retornaCartaQueJoga().getCor())){
                            indiceGanhando = j; 
                            empate = false;
                        }
                    }
                }                          
            break;

            case 2:     //Ganha quem tiver o menor tempo de decomposição
                indiceGanhando = jogadorDaVez;
                for (int j = 0; j < painelGame.retornaJogadores().size(); j++) {
                    if(jogadorDaVez != j){
                        if(painelGame.getJogador(indiceGanhando).retornaCartaQueJoga().getTempoDecomposicao() > painelGame.retornaJogadores().get(j).retornaCartaQueJoga().getTempoDecomposicao()){
                            indiceGanhando = j;  
                            empate = false;
                        }
                        else if(painelGame.getJogador(indiceGanhando).retornaCartaQueJoga().getTempoDecomposicao() == painelGame.getJogador(j).retornaCartaQueJoga().getTempoDecomposicao())
                            empate = true;  
                    }
                }                       
            break;

            case 3:     //ganha quem é reciclavel
                indiceGanhando = jogadorDaVez;
                empate = false;
                for (int j = 0; j < painelGame.retornaJogadores().size(); j++) {
                    if(jogadorDaVez != j) {
                        if(painelGame.getJogador(j).retornaCartaQueJoga().isReciclavel())
                            empate = true;
                        
                    }
                }                         
            break;

            default:    //ganha quem tiver o menor ataque ao meio ambiente
                indiceGanhando = jogadorDaVez;
                for (int j = 0; j < painelGame.retornaJogadores().size(); j++) {
                    if(jogadorDaVez != j){
                        if(painelGame.getJogador(indiceGanhando).retornaCartaQueJoga().getAtaque() > painelGame.retornaJogadores().get(j).retornaCartaQueJoga().getAtaque()){
                            indiceGanhando = j;
                            empate = false;
                        }
                        else if(painelGame.getJogador(indiceGanhando).retornaCartaQueJoga().getAtaque() == painelGame.getJogador(j).retornaCartaQueJoga().getAtaque())
                           empate = true;
                   }
                }
            break;
        }   //Fim do switch case

        if(empate){
            JOptionPane.showMessageDialog(null,"Ouve empate!"); 
            for (int j = 0; j< painelGame.retornaJogadores().size(); j++) 
                cartasEmpate.insere(painelGame.getJogador(j).remove());            
        }
        else {
            /* 
            * popup que diz qual jogador da rodada venceu   
            */  
            JOptionPane.showMessageDialog(null,"Jogador(a) " +painelGame.getJogador(indiceGanhando).getNomeJogador()+ " venceu");                

            for (int j = 0; j < painelGame.retornaJogadores().size(); j++)
                painelGame.retornaJogadores().get(indiceGanhando).insere(painelGame.retornaJogadores().get(j).remove());                                                                          

            while (!cartasEmpate.vazia()) {                        
                painelGame.retornaJogadores().get(indiceGanhando).insere(cartasEmpate.remove());
            }

        }

        //Testa se jogador ficou sem cartas
        for (int j = 0; j < painelGame.retornaJogadores().size(); j++) { 
            if(painelGame.retornaJogadores().get(j).vazia()){
                    JOptionPane.showMessageDialog(null,painelGame.getJogador(j).getNomeJogador() + " ficou sem cartas e saiu do jogo!");
                    dados.removeJodador(j);
                    dados.revalidate();
                    dados.repaint();
                    painelGame.removeJogador(j);
                    painelGame.revalidate();
                    painelGame.repaint();
                    
                    indiceGanhando = 0;
                }
        }
        for (int i = 0; i < painelGame.retornaJogadores().size(); i++) {
            dados.atualizarCartasNaMaoJogador(i, painelGame.retornaCartasNaMao(i));
        }
        if(painelGame.retornaJogadores().size() == 1)
            return -1;
        else
            return indiceGanhando;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        EventQueue.invokeLater(new Runnable() {
        Scanner sc = new Scanner(System.in);
            @Override
            public void run() {
            	SuperTrunfoGameReciclagem jp = new SuperTrunfoGameReciclagem();
                jp.setVisible(true);
            }
        });
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void setBorder(Border createLineBorder) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
