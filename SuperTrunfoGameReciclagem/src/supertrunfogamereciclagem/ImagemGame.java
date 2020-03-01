/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supertrunfogamereciclagem;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author darle
 */
public class ImagemGame extends JPanel {
    private BufferedImage image;
    //private ImageIcon    icon ;
    
    public ImagemGame() {
    	try {      
            setBackground(new Color(200, 20, 200));
            image = ImageIO.read(new File("resources/Cartas/CartaVirada.png"));
    	} catch (IOException ex) {
            System.err.println("O arquivo da imagem da sala não pode ser aberta!");
    	}
    }
    public ImagemGame(String imagemAtual) {
    	try {      
            setBackground(new Color(200, 20, 200));
            image = ImageIO.read(new File("resources/Cartas/"+imagemAtual+".png"));
    	} catch (IOException ex) {
            System.err.println("O arquivo da imagem da sala não pode ser aberta!");
    	}
    }
    public void setImagemGame(String imagemAtual) {
    	try {      
            image = ImageIO.read(new File("resources/Cartas/"+imagemAtual+".png"));
    	} catch (IOException ex) {
            System.err.println("O arquivo da imagem da sala não pode ser aberta!");
    	}
    }
    public void setAImagemCartaVirada() {
    	try {      
            image = ImageIO.read(new File("resources/Cartas/CartaVirada.png"));
    	} catch (IOException ex) {
            System.err.println("O arquivo da imagem da sala não pode ser aberta!");
    	}
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //*  Para centralizar
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(this.getWidth() / 2, this.getHeight() / 2);
        g2d.translate(-image.getWidth(null) / 2, -image.getHeight(null) / 2);
        g2d.drawImage(image, 0, 0, null);
    }
}
