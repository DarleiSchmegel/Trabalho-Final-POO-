/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baralho;

/**
 *
 * @author darle
 */
public class Carta {
    //todo os dados disponiveis em uma carta
    protected String label;
    protected String cor;
    protected String tipo;
    protected int tempoDecomposicao;
    protected boolean reciclavel;
    protected int ataque;
    protected String vence[];

    public Carta(String label,String cor, String tipo, int tempoDecomposicao, boolean reciclavel, int ataque, String[] vence) {
        this.label = label;
        this.cor = cor;
        this.tipo = tipo;
        this.tempoDecomposicao = tempoDecomposicao;
        this.reciclavel = reciclavel;
        this.ataque = ataque;
        this.vence = vence;
    }

    public Carta() {
        
    }
    
    public String getLabel(){
        return label;
    }

    public String getCor() {
        return cor;
    }

    public String getTipo() {
        return tipo;
    }

    public int getTempoDecomposicao() {
        return tempoDecomposicao;
    }

    public boolean isReciclavel() {
        return reciclavel;
    }

    public int getAtaque() {
        return ataque;
    }
    public boolean ganhaDeQualCor(String oponentecor){
        for (String string : vence) {
            if(string.equals(oponentecor)){
                return true;//quer dizer que ele ganhou
            }
        }
        return false;//quer dizer que perdeu
    }

    
    public void toStringImprimeDados() {
        System.out.printf(
                "Carta {" +"%n" +
                "label=" + label + "%n" +
                "cor=" + cor + "%n" +
                "tipo=" + tipo + "%n" +
                "tempoDecomposicao=" + tempoDecomposicao + "%n" +
                "reciclavel=" + reciclavel + "%n" + 
                "ataque=" + ataque + "%n" +
                "vence= "               
                 );
                 cartasQueganhaString();
                
    }
    public void cartasQueganhaString(){
        for (String string : vence) {
            System.out.printf(string+",");
        }
        System.out.printf("%n}");
    }
    
}
