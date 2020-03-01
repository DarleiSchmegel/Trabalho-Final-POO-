/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supertrunfogamereciclagem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author darle
 */
public class PainelPegaOpcaoEquemGanha extends JPanel{
    private JLabel labelNome;
    private JTextField textopcao;
    private String opcao;
    private JButton buttonOk;
    private JPanel gridAux;

    public PainelPegaOpcaoEquemGanha(){
        this.opcao = "";
        setBackground(new Color(200, 20, 200));
        setBorder(BorderFactory.createLineBorder(new Color(200, 25, 255), 10));
	
        gridAux = new JPanel();
        gridAux.setBackground(new Color(200, 20, 200));
        gridAux.setLayout(new GridLayout(7,0));
                
                
        labelNome = new JLabel("Sua vez:");
        
        //Campos de Texto
        textopcao = new JTextField(2);
        
        buttonOk = new JButton("OK");
        buttonOk.setBackground(new Color(200, 20, 200));
        
        buttonOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                opcao = textopcao.getText(); 
            }
        });
        
        gridAux.add(labelNome);
        gridAux.add(textopcao);
        gridAux.add(buttonOk);
        add(gridAux,BorderLayout.NORTH);
    }

    public String getOpcao() {
        return this.opcao;
    }
    public void setOpcao() {
        opcao = "";
    }
    public void atualizarNome(String nomeJogador) {
		labelNome.setText("Vez do Jogador : " +nomeJogador);         
    }
    public JButton botaoEscolha(){
        return buttonOk;
    }
       
}
