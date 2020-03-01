/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baralho;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author darle
 */
public class Baralho {
    
    Carta cartaRead = new Carta();
    int tamanhodoBaralho;
    private FilaBaralho baralho;

    public Baralho() {
        
        Carta cartaAux = null;
        baralho = new FilaBaralho();
      
        String vermelhoVence[] = {"Amarelo","Verde","Marron","Cinza","Preto"};
        String azulVence[] = {"Vermelho","Amarelo","Verde","Marron","Cinza"};
        String amareloVence[] = {"Verde","Marron","Cinza","Preto","Branco"};
        String verdeVence[] = {"Marron","Cinza","Preto","Branco","Laranja"};
        String cinzaVence[] = {"Preto","Branco","Laranja","Roxo","Azul"};
        String laranjaVence[] = {"Roxo","Azul","Vermelho","Amarelo","Verde"};
        String marromVence[] = {"Cinza","Preto","Branco","Laranja","Roxo"};
        String roxoVence[] = {"Azul","Vermelho","Amarelo","Verde","Marrom"};
        String brancoVence[] = {"Laranja","Roxo","Azul","Vermelho","Amarelo"};
        String pretoVence[] = {"Branco" ,"Laranja","Roxo","Azul","Vermelho"};
        String VenceTodasAsCores[] = {"Vermelho","Amarelo","Verde","Marrom","Branco" ,"Laranja","Roxo","Azul","Cinza","Preto"};
        String PerdeTodasAsCores[] = {"Perde","Perde"};
        
        try {
            FileReader arquivo = new FileReader("resources/Cartas.txt");
            BufferedReader ler = new BufferedReader(arquivo);

            String linha = ler.readLine();
            while(linha!=null) {                
                String[] linhaNova = linha.split(",");
                cartaRead.label = linhaNova[0];
                cartaRead.cor = linhaNova[1];
                cartaRead.tipo = linhaNova[2] ;
                cartaRead.tempoDecomposicao = Integer.parseInt(linhaNova[3]);   //int
                cartaRead.reciclavel = Boolean.parseBoolean(linhaNova[4]);  //boolean
                cartaRead.ataque = Integer.parseInt(linhaNova[5]);  //int            
                
                if(cartaRead.cor.equals("Vermelho"))
                    cartaAux = new Carta(cartaRead.label,cartaRead.cor,cartaRead.tipo,cartaRead.tempoDecomposicao,cartaRead.reciclavel,cartaRead.ataque,vermelhoVence);
                if(cartaRead.cor.equals("Azul"))
                    cartaAux = new Carta(cartaRead.label,cartaRead.cor,cartaRead.tipo,cartaRead.tempoDecomposicao,cartaRead.reciclavel,cartaRead.ataque,azulVence);
                if(cartaRead.cor.equals("Amarelo"))
                    cartaAux = new Carta(cartaRead.label,cartaRead.cor,cartaRead.tipo,cartaRead.tempoDecomposicao,cartaRead.reciclavel,cartaRead.ataque,amareloVence);
                if(cartaRead.cor.equals("Verde"))
                    cartaAux = new Carta(cartaRead.label,cartaRead.cor,cartaRead.tipo,cartaRead.tempoDecomposicao,cartaRead.reciclavel,cartaRead.ataque,verdeVence);
                if(cartaRead.cor.equals("Cinza"))
                    cartaAux = new Carta(cartaRead.label,cartaRead.cor,cartaRead.tipo,cartaRead.tempoDecomposicao,cartaRead.reciclavel,cartaRead.ataque,cinzaVence);
                if(cartaRead.cor.equals("Laranja"))
                    cartaAux = new Carta(cartaRead.label,cartaRead.cor,cartaRead.tipo,cartaRead.tempoDecomposicao,cartaRead.reciclavel,cartaRead.ataque,laranjaVence);
                if(cartaRead.cor.equals("Marrom"))
                    cartaAux = new Carta(cartaRead.label,cartaRead.cor,cartaRead.tipo,cartaRead.tempoDecomposicao,cartaRead.reciclavel,cartaRead.ataque,marromVence);
                if(cartaRead.cor.equals("Roxo"))
                    cartaAux = new Carta(cartaRead.label,cartaRead.cor,cartaRead.tipo,cartaRead.tempoDecomposicao,cartaRead.reciclavel,cartaRead.ataque,roxoVence);
                if(cartaRead.cor.equals("Branco"))
                    cartaAux = new Carta(cartaRead.label,cartaRead.cor,cartaRead.tipo,cartaRead.tempoDecomposicao,cartaRead.reciclavel,cartaRead.ataque,brancoVence);
                if(cartaRead.cor.equals("Preto"))
                    cartaAux = new Carta(cartaRead.label,cartaRead.cor,cartaRead.tipo,cartaRead.tempoDecomposicao,cartaRead.reciclavel,cartaRead.ataque,pretoVence);
                if(cartaRead.cor.equals("Vermelho"))
                    cartaAux = new Carta(cartaRead.label,cartaRead.cor,cartaRead.tipo,cartaRead.tempoDecomposicao,cartaRead.reciclavel,cartaRead.ataque,vermelhoVence);
                if(cartaRead.cor.equals("Colorido"))
                    cartaAux = new Carta(cartaRead.label,cartaRead.cor,cartaRead.tipo,cartaRead.tempoDecomposicao,cartaRead.reciclavel,cartaRead.ataque,VenceTodasAsCores);
                if(cartaRead.cor.equals("Perde"))
                    cartaAux = new Carta(cartaRead.label,cartaRead.cor,cartaRead.tipo,cartaRead.tempoDecomposicao,cartaRead.reciclavel,cartaRead.ataque,PerdeTodasAsCores);
                
                baralho.insere(cartaAux);                
                tamanhodoBaralho++;
                linha = ler.readLine();
            }                        
            //baralho.toStringImprimeDados();
            //System.out.println("Total de cartas: " + baralho.cartas.size());
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo!");
            e.getMessage();
        }          
    }
    /*
    *retorna o tamanho original do baralho
    */
    public  int baralhoSize(){
        return tamanhodoBaralho;
    }
    /*
    *retorna como esta o baralho enquanto são removidas as cartas  da fila 
    *e destribuidas aos jogadores
    */
    public FilaBaralho atualBaralho(){
        return baralho;
    }
    
    public void printBaralho() {
          while(!baralho.vazia()){
              baralho.toStringImprimeDados();
              baralho.remove();
          }
    }
}
