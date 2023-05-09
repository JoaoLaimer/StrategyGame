/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainstrategygame;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author jvlai
 */
public class BotoesUtil extends JPanel{
    
    GridBagConstraints g = new GridBagConstraints();
    List<JButton> botoes = new ArrayList<>();
    JButton pecasAdversario = new JButton("PC Random");
    JButton pecasJogador = new JButton("Player Random");
    JButton resetTabuleiro = new JButton("Reset");
    JButton mudaRodada = new JButton("Inicia Jogo");
    JButton debug = new JButton("DEBUG");
    JButton dica = new JButton("Dica");
    
    BotoesUtil()
    {
        botoes.add(pecasAdversario);
        botoes.add(pecasJogador);
        botoes.add(resetTabuleiro);
        botoes.add(mudaRodada);
        botoes.add(debug);
        botoes.add(dica);
        setLayout(new GridBagLayout());
        constroiBotoesUtil();
    }
    private void constroiBotoesUtil()
    {
        int qnt = 0;
        g.insets = new java.awt.Insets(1, 1, 1, 1);
        
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 2; j++)
            {
                botoes.get(qnt).setPreferredSize(new java.awt.Dimension(120, 50));
                botoes.get(qnt).setBackground(new java.awt.Color(204,204,204));
               
                g.gridx = i;
                g.gridy = j;
                
                add(botoes.get(qnt),g);
                qnt++;
            }
        }
    }
    public JButton getBotao(int index)
    {
        return this.botoes.get(index);
    }
    public GridBagConstraints getConstrains()
    {
        return g;
    }
} 
