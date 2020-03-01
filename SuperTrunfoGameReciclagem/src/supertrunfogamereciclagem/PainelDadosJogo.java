/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supertrunfogamereciclagem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author darle
 */
public class PainelDadosJogo extends JPanel {
    private JLabel tituloJanela;
    private List<PainelDadosJogador> jogador = new LinkedList<PainelDadosJogador>();
    JPanel painelJogadores;

    public PainelDadosJogo() {
        setBackground(Color.CYAN);
        setBorder(BorderFactory.createLineBorder(new Color(255, 25, 255), 10));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        tituloJanela = new JLabel("Dados do Jogo");
        add(tituloJanela,BorderLayout.NORTH);

        painelJogadores = new JPanel();
        painelJogadores.setLayout(new GridLayout(4,0));
        add(painelJogadores,BorderLayout.CENTER);

    }
    public void atualizarNomeJogador(int i ,String nomeJogador) {
        jogador.add(new PainelDadosJogador());
        jogador.get(i).atualizarNome(nomeJogador);
        painelJogadores.add(jogador.get(i));
    }
    public void atualizarCartasNaMaoJogador(int i ,int quantCartas) {
        jogador.get(i).atualizaQuantCartasMao(quantCartas);
    }
    public void removeJodador(int i){
        painelJogadores.remove(jogador.get(i));
        jogador.remove(i);
    }
}
