/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supertrunfogamereciclagem;

import baralho.Carta;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author darle
 */
public class PainelGame extends JPanel{
            
        //private Jogador[] gridJogador;
        private List<Jogador> gridJogador = new LinkedList<Jogador>();
        private JLabel descricao;
        private JPanel tituloGame;
        public PainelGame() {
                
                setLayout(new GridLayout(0,5));   
                //new PainelCor();
                setBackground(new Color(200, 20, 200));
                
               
                TituloGame();
                
        }
        
    public void mostraCartaJogadorDavez(int i){
        gridJogador.get(i).setImagemTopo();
    }
    public void naoMostraCartaJogador(int i){
        gridJogador.get(i).setImagemCartaVirada();
    }  
    //adcionando um novo jogador ao jogo
    public void addJogador(int i ,String nome){
        Jogador gridJogadorAux = new Jogador(nome);
        gridJogador.add(gridJogadorAux);
        
        //JOptionPane.showMessageDialog(null,"MENSAGEM AQUI");
        //gridJogador2.gridJogador();
        add(gridJogador.get(i));
    }
    public void removeJogador(int i){
        remove(gridJogador.get(i));
        gridJogador.remove(i);
    }
    public int retornaCartasNaMao(int i){
        return gridJogador.get(i).NumeroDeCartas();
    }
    public List<Jogador> retornaJogadores(){
        return gridJogador;
    }
    public Jogador getJogador(int i){
        return gridJogador.get(i);
    }
    
        
   // public get
    public void setCartaGridJogador(int i,Carta carta) {
        gridJogador.get(i).insere(carta);
    }    
    public void mostraImagemTopo(){
        
    }
                
                
    //*Aqui agente pode editar o titulo que vai ficar no topo do game         
    public void TituloGame(){
        descricao = new JLabel("Bem Vindo ao Jogo Imagem Aqui");
            tituloGame = new JPanel();
            tituloGame.setBackground(new Color(200, 20, 200));

            tituloGame.add(descricao,BorderLayout.NORTH);
    }
    public JPanel RetornaTitulo(){
        return tituloGame;
    }
        
        
        
    
}
