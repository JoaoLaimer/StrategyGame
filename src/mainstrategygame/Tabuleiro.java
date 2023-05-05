/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainstrategygame;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Math.sqrt;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author jvlai
 */
public class Tabuleiro extends JPanel{
    public static final int NUMERO_DE_CASAS = 25;
    private Celula[][] tabuleiro;
    
    private Peça peçaSelecionada;
    private String nomeDaPeça;
    private char tipoDePeça;
    
    private boolean bandeiraDisponivel = true;
    private boolean marechalDisponivel = true;
    private boolean espiaoDisponivel = true;
    private int soldadosDisponiveis = 3;
    private int caboArmeiroDisponiveis = 2;
    private int bombasDisponiveis = 2;
    
    private Peça peçaPosicionada;
    GridBagConstraints  g = new GridBagConstraints();
    
    GridBagConstraints  g = new GridBagConstraints();
       
    public Tabuleiro()
    {
        tabuleiro = new Celula[(int)(sqrt(NUMERO_DE_CASAS))][(int)(sqrt(NUMERO_DE_CASAS))];
        setLayout(new GridBagLayout());
        constroiTabuleiro();
    }
    //Coloquei esses getters e setters pra conseguir fazer os bagulho
    public void setPeçaSelecionada(Peça peçaSelecionada) {
        this.peçaSelecionada = peçaSelecionada;
        atualizaTabuleiro();
    }
    
    public void setTipoDePeça(char tipoDePeça){
        this.tipoDePeça = tipoDePeça;
    }
    
    public void setNomeDaPeça(String nomeDaPeça){
        this.nomeDaPeça = nomeDaPeça;
    }
    
    public Peça getPeçaSelecionada() {
        return peçaSelecionada;
    }

    public String getNomeDaPeça() {
        return nomeDaPeça;
    }

    public char getTipoDePeça() {
        return tipoDePeça;
    }
                    
    private void constroiTabuleiro()
    {
        g.insets = new java.awt.Insets(1, 1, 1, 1);
        for(int i = 0 ; i < sqrt(NUMERO_DE_CASAS); i++)
        {
            for(int j = 0; j < sqrt(NUMERO_DE_CASAS); j++)
            {
                g.gridx=i;
                g.gridy=j;
                //Cria o tabuleiro
                tabuleiro[i][j] = CelulaFactory.factory(' ');
                tabuleiro[i][j].setBackground(new java.awt.Color(204, 255, 204));
                tabuleiro[i][j].setPreferredSize(new java.awt.Dimension(50, 50));
                
                //Seta o tabuleiro como falso
                tabuleiro[i][j].setEnabled(false);
                //Pega as coordenadas da matriz
                final int x = i;
                final int y = j;
                //Ao clicar no botão pega as "informações do botão" e chama a função que coloca uma peça na posição desse botão
                tabuleiro[i][j].addActionListener(new ActionListener() 
                {
                    public void actionPerformed(ActionEvent e) 
                    {   
                        Celula botãoClicado = (Celula) e.getSource();
                        colocaPeçaNoTabuleiro(botãoClicado, x, y);
                    }
                });
                //MUDEI AS POSIÇÕES DO LAGO!!!
                if((i == 1 && j == 2)||(i == 3 && j == 2))
                {
                    tabuleiro[i][j].setEnabled(false);
                    tabuleiro[i][j].setBackground(new java.awt.Color(204, 204, 255));
                }
                
                add(tabuleiro[i][j],g);
            }
        }
    }
    
    public void iteradorPeçasDisponiveis(char tipoDePeça){
        if( tipoDePeça == 'B')
            bombasDisponiveis--;
        if( tipoDePeça == 'C')
            caboArmeiroDisponiveis--;
        if( tipoDePeça == 'S')
            soldadosDisponiveis--;
        if( tipoDePeça == 'M')
            marechalDisponivel = false;
        if( tipoDePeça == 'E')
            espiaoDisponivel = false;
        if( tipoDePeça == 'F')
            espiaoDisponivel = false;
    }
    public boolean verificaPeçasDisponiveis(char tipoDePeça){
        switch(tipoDePeça){
            case 'B':
                return (bombasDisponiveis > 0);
            case 'c':
                return (caboArmeiroDisponiveis > 0);
            case 'S':
                return (soldadosDisponiveis > 0);
            case 'M':
                return marechalDisponivel;
            case 'E':
                return espiaoDisponivel;
            case 'F':
                return bandeiraDisponivel;
            default:
                return false;
        }
    }
    public void colocaPeçaNoTabuleiro(Celula botãoClicado, int x, int y)
    {
        for (int i = 0; i < sqrt(NUMERO_DE_CASAS); i++) 
        {
            for (int j = 0; j < sqrt(NUMERO_DE_CASAS); j++) 
            {
                if (x == i && y == j)
                {
                    if (j > 2)
                    {

                        Celula novaCelula = CelulaFactory.factory(getTipoDePeça());
                        if (verificaPeçasDisponiveis(getTipoDePeça()))
                        {
                            iteradorPeçasDisponiveis(getTipoDePeça());
                            if ( getTipoDePeça() == 'F' && y == 3)
                            {
                                System.out.println("Só é possivel colocar a bandeira na primeira fileira!!!, tente novamente");
                                return;
                            }
                            tabuleiro[i][j] = novaCelula;
                        //Só copiei o botão já feito, mas não ta ficando igual, não sei o que mais tem que mudar nele
                        
                        novaCelula.setBackground(new java.awt.Color(204, 255, 204));
                        novaCelula.setPreferredSize(new java.awt.Dimension(50, 50));
                        g.insets = new java.awt.Insets(1, 1, 1, 1); 
                        g.gridx = x;
                        g.gridy = y;
                        
                        remove(botãoClicado);
                        add(novaCelula, g);
                        revalidate();
                        repaint();

                        setPeçaSelecionada(null);
                        //setTipoDePeça(null);
                        setNomeDaPeça(null);
                        }
                    }
                }
            }
        }
    }
    
    private void atualizaTabuleiro() {
        for (int i = 0; i < sqrt(NUMERO_DE_CASAS); i++) {
            for (int j = 0; j < sqrt(NUMERO_DE_CASAS); j++) {
                if (peçaSelecionada != null) {
                    tabuleiro[i][j].setEnabled(true);
                }   else {
                    tabuleiro[i][j].setEnabled(false);
                }
            }
        }
    }
    public void setPecasComputador(){
        
        
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 2; j++)
            {
                remove(tabuleiro[i][j]);
                tabuleiro[i][j] = setPecaAleatoria();
                
                        g.insets = new java.awt.Insets(1, 1, 1, 1); 
                        g.gridx = i;
                        g.gridy = j;
                add(tabuleiro[i][j], g);
                atualizaTabuleiro();
            }
        }
    }
    private static Celula setPecaAleatoria()
    {
        List<Character> tipos = Arrays.asList('B','C','S','E','F','M'); 
        Celula celula;
        Random random = new Random();
        
        char escolhido = tipos.get(random.nextInt(5));
        celula = CelulaFactory.factory(escolhido);
        
        celula.setBackground(new java.awt.Color(204, 255, 204));
        celula.setPreferredSize(new java.awt.Dimension(50, 50));
        System.out.println(celula.getTipo());
        return celula;
        
    }
}

    
