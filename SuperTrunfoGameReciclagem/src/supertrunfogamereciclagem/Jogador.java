/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supertrunfogamereciclagem;

import baralho.Carta;
import baralho.FilaBaralho;
import baralho.Baralho;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author darle
 */
public class Jogador extends JPanel{
    //JPanel gridJogador;
    private JLabel nome;
    private JLabel cartasNaMao;
    private String nomeJogador;
    private JPanel janelaDoJogador;
    private JPanel  imagemCartaTopo;
    private ImagemGame imagemAtual;
    private FilaBaralho baralho;

    
    //*/Inicia o painel do Jogador na parte esquerda da tela
    public Jogador(String nomeJogador){                
        this.nomeJogador = nomeJogador;
        janelaDoJogador = new JPanel();
        imagemCartaTopo = new JPanel();        
        imagemAtual = new ImagemGame();
        baralho = new FilaBaralho();
        setBackground(new Color(200, 20, 200));
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 20));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        nome = new JLabel("Nome: " + nomeJogador);
        cartasNaMao = new JLabel("cartasNaMao: ");

       add(nome,BorderLayout.NORTH);
       add(imagemAtual,BorderLayout.CENTER);


        setVisible(true);               
    }
    
    public String getNomeJogador(){
        return  this.nomeJogador;
    }
    public void setImagemTopo(){
        this.imagemAtual.setImagemGame(baralho.retornaLabelCartaPosicao(0));
    }
    public void setImagemCartaVirada(){
        this.imagemAtual.setAImagemCartaVirada();
    }
    /*
    *retorna todo o baralho atual do jogador
    */
    public FilaBaralho retornaBaralho(){
        return baralho;
    }
    public Carta retornaCartaQueJoga(){
        return baralho.retornaCartaQueJoga();
    }
    /*
    *pode setar todas as cartas do jogador de uma unica vez
    */
    public void cartasDoJogador(FilaBaralho baralho){
        this.baralho = baralho;
    }
    /*
    *insere uma carta na mão do jogador
    */
    public void insere(Carta carta){
        this.baralho.insere(carta);
    }
    /*
    *remove uma carta da mão do jogador
    */
    public Carta remove() {
       return  this.baralho.remove();
    }
    /*
    *quando a mão do jogador fica vazia ele perde o jogo
    */
    public boolean vazia() {
        return this.baralho.vazia();
    }/*
    *retorna o numero de cartas que o jogador ainda tem nas mãos
    */
    public int NumeroDeCartas(){
        return this.baralho.NumeroDeCartas();
    }
    
    public void atualizarNome(String nomeJogador) {
                this.nomeJogador = nomeJogador;
		nome.setText("Nome: " +nomeJogador);         
    }
    public void atualizaQuantCartasMao(){
            
            cartasNaMao.setText("cartasNaMao: " + baralho.NumeroDeCartas());

    }
    
    
}
