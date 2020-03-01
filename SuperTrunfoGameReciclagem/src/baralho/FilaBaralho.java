/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baralho;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author darle
 */
public class FilaBaralho {
    List<Carta> cartas ;

    public FilaBaralho(List<Carta> cartas) {
        this.cartas = cartas;
    }
    public FilaBaralho() {
        this.cartas = new LinkedList<Carta>();
    }
    
    public void insere(Carta carta) {
        this.cartas.add(carta);
    }
    public Carta remove() {
        return this.cartas.remove(0);
    }
    public Carta removeRand() {
        Random gerador = new Random();
        return this.cartas.remove(gerador.nextInt(cartas.size()));
    }
    public boolean vazia() {
        return this.cartas.size() == 0;
    }
    public int NumeroDeCartas(){
        return this.cartas.size();
    }
    public String retornaLabelCartaPosicao(int i){
        return cartas.get(i).getLabel();
    }
    public void toStringImprimeDados(){
        this.cartas.get(0).toStringImprimeDados();
    }
    public Carta retornaCartaQueJoga(){
        return cartas.get(0);
    }
}
