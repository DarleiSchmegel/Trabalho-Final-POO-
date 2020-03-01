/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supertrunfogamereciclagem;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author darle
 */
public class PainelDadosJogador extends JPanel{
    JLabel nome;
    JLabel cartasNaMao;
    /*
    *testenado o ver carta
    */
    JButton botaoVerCarta = new JButton("ver carta");
    
    
    public PainelDadosJogador(){
        //gridJogador = new JPanel();
                setBackground(new Color(255, 255, 0));
		setBorder(BorderFactory.createLineBorder(new Color(200, 20, 200), 2));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		// Label com o nome do Heroi
                
		nome = new JLabel("Nome:                                   ");
		cartasNaMao = new JLabel("Cartas: ");
                botaoVerCarta.setVisible(false);
		add(nome);
		add(cartasNaMao);
                add(botaoVerCarta);
                setVisible(true);
    }
    public void atualizarNome(String nomeJogador) {
		nome.setText("Nome: " +nomeJogador);         
    }
    public void atualizaQuantCartasMao(int quantCartas){
            
            cartasNaMao.setText("Cartas: " + quantCartas);

    }
    
}
