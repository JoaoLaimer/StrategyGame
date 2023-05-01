/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mainstrategygame;

import java.awt.Color;
import static java.awt.Color.GREEN;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.lang.Math;


public class Board extends javax.swing.JFrame {
    private int rodada = 1;
    private static int linhaUltimoBotãoClicado = -1;
    private static int colunaUltimoBotãoClicado = -1;
    private static JButton ultimoBotãoClicado = null;
    
    private Peça[][] matrizTabuleiro = new Peça[5][5];
    private Peça peçaSelecionada;
    private Peça peçaPosicionada;
    
    private int bombasUsadas = 0;
    private boolean espiãoUsado = false;
    private boolean bandeiraEstáPosicionada = false;
    
    private Bomba bombaSelecionada;
    private Bomba bombaPosicionada;
    
    private Bandeira bandeiraSelecionada;
    private Bandeira bandeiraPosicionada;
    
    private Espião espiãoSelecionado;
    private Espião espiãoPosicionado;
    
    private void atualizaInformaçõesDoUltimoBotãoClicado(JButton button) {
        ultimoBotãoClicado = button;
        int[] coords = pegaCoordenadas(button);
        linhaUltimoBotãoClicado = coords[0];
        colunaUltimoBotãoClicado = coords[1];
    }
    
    private void atualizaCorBotao(JButton button, Color cor) {
        button.setBackground(cor);
        if (ultimoBotãoClicado != null && !ultimoBotãoClicado.equals(button)) {
            ultimoBotãoClicado.setBackground(null);
        }
        ultimoBotãoClicado = button;
    }
    
    private int[] pegaCoordenadas(JButton buttonClicked) {
        Container parent = buttonClicked.getParent();
        GridBagLayout gridBagLayout = (GridBagLayout) parent.getLayout();
        GridBagConstraints constraints = gridBagLayout.getConstraints(buttonClicked);
        int row = constraints.gridy;
        int column = constraints.gridx;
        return new int[] {row, column};
    }

    /*
    private int calculoDistância (JButton botãoSelecionado, JButton botãoASelecionar){
        int []coordenadaBotãoSelecionado = pegaCoordenadas(botãoSelecionado);
        int []coordenadaBotãoASelecionar = pegaCoordenadas(botãoASelecionar);
        int distância = Math.abs(coordenadaBotãoSelecionado[0] - coordenadaBotãoASelecionar[0]) + Math.abs(coordenadaBotãoSelecionado[1] - coordenadaBotãoASelecionar[1]);
        return distância;
    }
    */
    
    private void colocaPeçaNoBotão (JButton botãoClicado, Peça peça){
        if ( peçaSelecionada  != null){
            int[] coordenadas = pegaCoordenadas(botãoClicado);
            int linha = coordenadas [0];
            if ( linha > 2){
                if (peçaSelecionada instanceof Bomba) {
                    peçaPosicionada = new Bomba(peçaSelecionada.getNome(), peçaSelecionada.getNivel(),coordenadas);
                    botãoClicado.setText("💣");  
                    matrizTabuleiro[coordenadas[0]][coordenadas[1]] = peçaPosicionada;
                    bombasUsadas++;
                } else if (peçaSelecionada instanceof Bandeira) {
                    peçaPosicionada = new Bandeira(peçaSelecionada.getNome(), peçaSelecionada.getNivel(),coordenadas);
                    botãoClicado.setText("🏴");
                    matrizTabuleiro[coordenadas[0]][coordenadas[1]] = peçaPosicionada;
                    bandeiraEstáPosicionada = true;
                } else if (peçaSelecionada instanceof Espião) {
                    peçaPosicionada = new Espião(peçaSelecionada.getNome(), peçaSelecionada.getNivel(),coordenadas);
                    botãoClicado.setText("🕵️ ");
                    matrizTabuleiro[coordenadas[0]][coordenadas[1]] = peçaPosicionada;
                    espiãoUsado = true;
                }
                peçaSelecionada = null;
            }
        }
    }
    
    private void imprimeMatriz (Peça [][] matrizTabuleiro){
        jConsole.append("\n");
        for (int i = 0; i < matrizTabuleiro.length; i++) {
            for (int j = 0; j < matrizTabuleiro[i].length; j++) {
                if (matrizTabuleiro[i][j] instanceof Peça){
                    jConsole.append(matrizTabuleiro[i][j].getNome());
                }
                else {
                    jConsole.append(" 0 ");
                }
            }
            jConsole.append("\n");
        }
    }
    
    public Board() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButtonPeça1 = new javax.swing.JButton();
        jButtonPeça2 = new javax.swing.JButton();
        jButtonPeça3 = new javax.swing.JButton();
        jButtonPeça4 = new javax.swing.JButton();
        jButtonPeça5 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jConsole = new javax.swing.JTextArea();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("StrategyGame");
        setMaximumSize(new java.awt.Dimension(600, 600));
        setMinimumSize(new java.awt.Dimension(600, 600));
        setName("Board"); // NOI18N
        setPreferredSize(new java.awt.Dimension(600, 600));
        setSize(new java.awt.Dimension(500, 500));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jButton1.setBackground(new java.awt.Color(204, 255, 204));
        jButton1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton1.setName(""); // NOI18N
        jButton1.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        getContentPane().add(jButton1, gridBagConstraints);

        jButton4.setBackground(new java.awt.Color(204, 255, 204));
        jButton4.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        getContentPane().add(jButton4, gridBagConstraints);

        jButton21.setBackground(new java.awt.Color(204, 255, 204));
        jButton21.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton21.setName(""); // NOI18N
        jButton21.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton21MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        getContentPane().add(jButton21, gridBagConstraints);

        jButton22.setBackground(new java.awt.Color(204, 255, 204));
        jButton22.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton22.setName(""); // NOI18N
        jButton22.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton22MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        getContentPane().add(jButton22, gridBagConstraints);

        jButton2.setBackground(new java.awt.Color(204, 255, 204));
        jButton2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton2.setName(""); // NOI18N
        jButton2.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        getContentPane().add(jButton2, gridBagConstraints);

        jButton8.setBackground(new java.awt.Color(204, 255, 204));
        jButton8.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton8.setName(""); // NOI18N
        jButton8.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        getContentPane().add(jButton8, gridBagConstraints);

        jButton9.setBackground(new java.awt.Color(204, 255, 204));
        jButton9.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton9.setName(""); // NOI18N
        jButton9.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton9MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        getContentPane().add(jButton9, gridBagConstraints);

        jButton12.setBackground(new java.awt.Color(204, 255, 255));
        jButton12.setEnabled(false);
        jButton12.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton12.setName(""); // NOI18N
        jButton12.setPreferredSize(new java.awt.Dimension(50, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        getContentPane().add(jButton12, gridBagConstraints);

        jButton23.setBackground(new java.awt.Color(204, 255, 204));
        jButton23.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton23.setName(""); // NOI18N
        jButton23.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton23MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        getContentPane().add(jButton23, gridBagConstraints);

        jButton13.setBackground(new java.awt.Color(204, 255, 204));
        jButton13.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton13.setName(""); // NOI18N
        jButton13.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton13MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        getContentPane().add(jButton13, gridBagConstraints);

        jButton16.setBackground(new java.awt.Color(204, 255, 204));
        jButton16.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton16.setName(""); // NOI18N
        jButton16.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton16MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        getContentPane().add(jButton16, gridBagConstraints);

        jButton17.setBackground(new java.awt.Color(204, 255, 204));
        jButton17.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton17.setName(""); // NOI18N
        jButton17.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton17MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        getContentPane().add(jButton17, gridBagConstraints);

        jButton3.setBackground(new java.awt.Color(204, 255, 204));
        jButton3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton3.setName(""); // NOI18N
        jButton3.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        getContentPane().add(jButton3, gridBagConstraints);

        jButton6.setBackground(new java.awt.Color(204, 255, 204));
        jButton6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton6.setName(""); // NOI18N
        jButton6.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        getContentPane().add(jButton6, gridBagConstraints);

        jButton7.setBackground(new java.awt.Color(204, 255, 204));
        jButton7.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton7.setName(""); // NOI18N
        jButton7.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        getContentPane().add(jButton7, gridBagConstraints);

        jButton24.setBackground(new java.awt.Color(204, 255, 204));
        jButton24.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton24.setName(""); // NOI18N
        jButton24.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton24MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        getContentPane().add(jButton24, gridBagConstraints);

        jButton5.setBackground(new java.awt.Color(204, 255, 204));
        jButton5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton5.setName(""); // NOI18N
        jButton5.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        getContentPane().add(jButton5, gridBagConstraints);

        jButton11.setBackground(new java.awt.Color(204, 255, 204));
        jButton11.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton11.setName(""); // NOI18N
        jButton11.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton11MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        getContentPane().add(jButton11, gridBagConstraints);

        jButton14.setBackground(new java.awt.Color(204, 255, 255));
        jButton14.setEnabled(false);
        jButton14.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton14.setName(""); // NOI18N
        jButton14.setPreferredSize(new java.awt.Dimension(50, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        getContentPane().add(jButton14, gridBagConstraints);

        jButton18.setBackground(new java.awt.Color(204, 255, 204));
        jButton18.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton18.setName(""); // NOI18N
        jButton18.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton18MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        getContentPane().add(jButton18, gridBagConstraints);

        jButton10.setBackground(new java.awt.Color(204, 255, 204));
        jButton10.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton10.setName(""); // NOI18N
        jButton10.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton10MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        getContentPane().add(jButton10, gridBagConstraints);

        jButton25.setBackground(new java.awt.Color(204, 255, 204));
        jButton25.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton25.setName(""); // NOI18N
        jButton25.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton25MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        getContentPane().add(jButton25, gridBagConstraints);

        jButton20.setBackground(new java.awt.Color(204, 255, 204));
        jButton20.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton20.setName(""); // NOI18N
        jButton20.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton20MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        getContentPane().add(jButton20, gridBagConstraints);

        jButton15.setBackground(new java.awt.Color(204, 255, 204));
        jButton15.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton15.setName(""); // NOI18N
        jButton15.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton15MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        getContentPane().add(jButton15, gridBagConstraints);

        jButton19.setBackground(new java.awt.Color(204, 255, 204));
        jButton19.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton19.setName(""); // NOI18N
        jButton19.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton19MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        getContentPane().add(jButton19, gridBagConstraints);

        jButtonPeça1.setText("💣");
        jButtonPeça1.setPreferredSize(new java.awt.Dimension(50, 50));
        jButtonPeça1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonPeça1MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        getContentPane().add(jButtonPeça1, gridBagConstraints);

        jButtonPeça2.setText("🏴");
        jButtonPeça2.setPreferredSize(new java.awt.Dimension(50, 50));
        jButtonPeça2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonPeça2MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        getContentPane().add(jButtonPeça2, gridBagConstraints);

        jButtonPeça3.setText("🕵️ ");
        jButtonPeça3.setPreferredSize(new java.awt.Dimension(50, 50));
        jButtonPeça3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonPeça3MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        getContentPane().add(jButtonPeça3, gridBagConstraints);

        jButtonPeça4.setText("🔧");
        jButtonPeça4.setPreferredSize(new java.awt.Dimension(50, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        getContentPane().add(jButtonPeça4, gridBagConstraints);

        jButtonPeça5.setText("🎖️");
        jButtonPeça5.setPreferredSize(new java.awt.Dimension(50, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        getContentPane().add(jButtonPeça5, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 7;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(jSeparator2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(jSeparator1, gridBagConstraints);

        jConsole.setEditable(false);
        jConsole.setColumns(20);
        jConsole.setLineWrap(true);
        jConsole.setRows(5);
        jConsole.setBorder(javax.swing.BorderFactory.createTitledBorder("Console"));
        jScrollPane1.setViewportView(jConsole);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(jScrollPane1, gridBagConstraints);

        jButton26.setText("Imprime Matriz");
        jButton26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton26MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 150);
        getContentPane().add(jButton26, gridBagConstraints);

        jButton27.setText("Reset ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 150, 0, 0);
        getContentPane().add(jButton27, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        if ( rodada == 1){
            JButton botãoClicado = (JButton) evt.getSource();
            int[] coordenadas = pegaCoordenadas(botãoClicado);
            
            // ESSE JEITO AQUI É GAMBIARRA, PARA EVITAR ESSA CADEIA DE IF EU PRECISO COLOCAR AS PEÇAS DISPONIVEIS EM UMA LISTA E APARTIR
            // DESSA LISTA, CHAMAR A PEÇA QUE EU QUERO COLOCAR NO BOTÃO;
            if ( bombaSelecionada != null )
                colocaPeçaNoBotão(botãoClicado, bombaSelecionada);
            else if ( bandeiraSelecionada != null )
                colocaPeçaNoBotão(botãoClicado, bandeiraSelecionada);
            else if ( espiãoSelecionado != null)
                colocaPeçaNoBotão(botãoClicado, espiãoSelecionado);
        }
        else if ( rodada == 2){
            JButton botãoClicado = (JButton) evt.getSource();
            int[] coordenadas = pegaCoordenadas(botãoClicado);   int linhaMatriz = coordenadas[0];   int colunaMatriz = coordenadas[1];
            System.out.println("Linha: " + linhaMatriz + " Coluna: " + colunaMatriz);
        
            atualizaCorBotao(botãoClicado, GREEN);
            if (ultimoBotãoClicado != null && !ultimoBotãoClicado.equals(botãoClicado)) {
                atualizaCorBotao (ultimoBotãoClicado,null);
            }
            ultimoBotãoClicado = botãoClicado;
        }
    }//GEN-LAST:event_jButton1MouseClicked
    
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        if ( rodada == 1){
            JButton botãoClicado = (JButton) evt.getSource();
            int[] coordenadas = pegaCoordenadas(botãoClicado);
            if ( bombaSelecionada != null )
                colocaPeçaNoBotão(botãoClicado, bombaSelecionada);
            else if ( bandeiraSelecionada != null )
                colocaPeçaNoBotão(botãoClicado, bandeiraSelecionada);
            else if ( espiãoSelecionado != null)
                colocaPeçaNoBotão(botãoClicado, espiãoSelecionado);
        }
        else if ( rodada == 2){
            JButton botãoClicado = (JButton) evt.getSource();
            int[] coordenadas = pegaCoordenadas(botãoClicado);   int linhaMatriz = coordenadas[0];   int colunaMatriz = coordenadas[1];
            System.out.println("Linha: " + linhaMatriz + " Coluna: " + colunaMatriz);
        
            atualizaCorBotao(botãoClicado, GREEN);
            if (ultimoBotãoClicado != null && !ultimoBotãoClicado.equals(botãoClicado)) {
                atualizaCorBotao (ultimoBotãoClicado,null);
            }
            ultimoBotãoClicado = botãoClicado;
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        if ( rodada == 1){
            JButton botãoClicado = (JButton) evt.getSource();
            int[] coordenadas = pegaCoordenadas(botãoClicado);
            if ( bombaSelecionada != null )
                colocaPeçaNoBotão(botãoClicado, bombaSelecionada);
            else if ( bandeiraSelecionada != null )
                colocaPeçaNoBotão(botãoClicado, bandeiraSelecionada);
            else if ( espiãoSelecionado != null)
                colocaPeçaNoBotão(botãoClicado, espiãoSelecionado);
        }
        else if ( rodada == 2){
            JButton botãoClicado = (JButton) evt.getSource();
            int[] coordenadas = pegaCoordenadas(botãoClicado);   int linhaMatriz = coordenadas[0];   int colunaMatriz = coordenadas[1];
            System.out.println("Linha: " + linhaMatriz + " Coluna: " + colunaMatriz);
        
            atualizaCorBotao(botãoClicado, GREEN);
            if (ultimoBotãoClicado != null && !ultimoBotãoClicado.equals(botãoClicado)) {
                atualizaCorBotao (ultimoBotãoClicado,null);
            }
            ultimoBotãoClicado = botãoClicado;
        }
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        if ( rodada == 1){
            JButton botãoClicado = (JButton) evt.getSource();
            int[] coordenadas = pegaCoordenadas(botãoClicado);
            if ( bombaSelecionada != null )
                colocaPeçaNoBotão(botãoClicado, bombaSelecionada);
            else if ( bandeiraSelecionada != null )
                colocaPeçaNoBotão(botãoClicado, bandeiraSelecionada);
            else if ( espiãoSelecionado != null)
                colocaPeçaNoBotão(botãoClicado, espiãoSelecionado);
        }
        else if ( rodada == 2){
            JButton botãoClicado = (JButton) evt.getSource();
            int[] coordenadas = pegaCoordenadas(botãoClicado);   int linhaMatriz = coordenadas[0];   int colunaMatriz = coordenadas[1];
            System.out.println("Linha: " + linhaMatriz + " Coluna: " + colunaMatriz);
        
            atualizaCorBotao(botãoClicado, GREEN);
            if (ultimoBotãoClicado != null && !ultimoBotãoClicado.equals(botãoClicado)) {
                atualizaCorBotao (ultimoBotãoClicado,null);
            }
            ultimoBotãoClicado = botãoClicado;
        }
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        if ( rodada == 1){
            JButton botãoClicado = (JButton) evt.getSource();
            int[] coordenadas = pegaCoordenadas(botãoClicado);
            if ( bombaSelecionada != null )
                colocaPeçaNoBotão(botãoClicado, bombaSelecionada);
            else if ( bandeiraSelecionada != null )
                colocaPeçaNoBotão(botãoClicado, bandeiraSelecionada);
            else if ( espiãoSelecionado != null)
                colocaPeçaNoBotão(botãoClicado, espiãoSelecionado);
        }
        else if ( rodada == 2){
            JButton botãoClicado = (JButton) evt.getSource();
            int[] coordenadas = pegaCoordenadas(botãoClicado);   int linhaMatriz = coordenadas[0];   int colunaMatriz = coordenadas[1];
            System.out.println("Linha: " + linhaMatriz + " Coluna: " + colunaMatriz);
        
            atualizaCorBotao(botãoClicado, GREEN);
            if (ultimoBotãoClicado != null && !ultimoBotãoClicado.equals(botãoClicado)) {
                atualizaCorBotao (ultimoBotãoClicado,null);
            }
            ultimoBotãoClicado = botãoClicado;
        }
    }//GEN-LAST:event_jButton6MouseClicked

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        if ( rodada == 1){
            JButton botãoClicado = (JButton) evt.getSource();
            int[] coordenadas = pegaCoordenadas(botãoClicado);
            if ( bombaSelecionada != null )
                colocaPeçaNoBotão(botãoClicado, bombaSelecionada);
            else if ( bandeiraSelecionada != null )
                colocaPeçaNoBotão(botãoClicado, bandeiraSelecionada);
            else if ( espiãoSelecionado != null)
                colocaPeçaNoBotão(botãoClicado, espiãoSelecionado);
        }
        else if ( rodada == 2){
            JButton botãoClicado = (JButton) evt.getSource();
            int[] coordenadas = pegaCoordenadas(botãoClicado);   int linhaMatriz = coordenadas[0];   int colunaMatriz = coordenadas[1];
            System.out.println("Linha: " + linhaMatriz + " Coluna: " + colunaMatriz);
        
            atualizaCorBotao(botãoClicado, GREEN);
            if (ultimoBotãoClicado != null && !ultimoBotãoClicado.equals(botãoClicado)) {
                atualizaCorBotao (ultimoBotãoClicado,null);
            }
            ultimoBotãoClicado = botãoClicado;
        }
    }//GEN-LAST:event_jButton7MouseClicked

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
        if ( rodada == 1){
            JButton botãoClicado = (JButton) evt.getSource();
            int[] coordenadas = pegaCoordenadas(botãoClicado);
            if ( bombaSelecionada != null )
                colocaPeçaNoBotão(botãoClicado, bombaSelecionada);
            else if ( bandeiraSelecionada != null )
                colocaPeçaNoBotão(botãoClicado, bandeiraSelecionada);
            else if ( espiãoSelecionado != null)
                colocaPeçaNoBotão(botãoClicado, espiãoSelecionado);
        }
        else if ( rodada == 2){
            JButton botãoClicado = (JButton) evt.getSource();
            int[] coordenadas = pegaCoordenadas(botãoClicado);   int linhaMatriz = coordenadas[0];   int colunaMatriz = coordenadas[1];
            System.out.println("Linha: " + linhaMatriz + " Coluna: " + colunaMatriz);
        
            atualizaCorBotao(botãoClicado, GREEN);
            if (ultimoBotãoClicado != null && !ultimoBotãoClicado.equals(botãoClicado)) {
                atualizaCorBotao (ultimoBotãoClicado,null);
            }
            ultimoBotãoClicado = botãoClicado;
        }
    }//GEN-LAST:event_jButton8MouseClicked

    private void jButton9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseClicked
        if ( rodada == 1){
            JButton botãoClicado = (JButton) evt.getSource();
            int[] coordenadas = pegaCoordenadas(botãoClicado);
            if ( bombaSelecionada != null )
                colocaPeçaNoBotão(botãoClicado, bombaSelecionada);
            else if ( bandeiraSelecionada != null )
                colocaPeçaNoBotão(botãoClicado, bandeiraSelecionada);
            else if ( espiãoSelecionado != null)
                colocaPeçaNoBotão(botãoClicado, espiãoSelecionado);
        }
        else if ( rodada == 2){
            JButton botãoClicado = (JButton) evt.getSource();
            int[] coordenadas = pegaCoordenadas(botãoClicado);   int linhaMatriz = coordenadas[0];   int colunaMatriz = coordenadas[1];
            System.out.println("Linha: " + linhaMatriz + " Coluna: " + colunaMatriz);
        
            atualizaCorBotao(botãoClicado, GREEN);
            if (ultimoBotãoClicado != null && !ultimoBotãoClicado.equals(botãoClicado)) {
                atualizaCorBotao (ultimoBotãoClicado,null);
            }
            ultimoBotãoClicado = botãoClicado;
        }
    }//GEN-LAST:event_jButton9MouseClicked

    private void jButton10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseClicked
        if ( rodada == 1){
            JButton botãoClicado = (JButton) evt.getSource();
            int[] coordenadas = pegaCoordenadas(botãoClicado);
            if ( bombaSelecionada != null )
                colocaPeçaNoBotão(botãoClicado, bombaSelecionada);
            else if ( bandeiraSelecionada != null )
                colocaPeçaNoBotão(botãoClicado, bandeiraSelecionada);
            else if ( espiãoSelecionado != null)
                colocaPeçaNoBotão(botãoClicado, espiãoSelecionado);
        }
        else if ( rodada == 2){
            JButton botãoClicado = (JButton) evt.getSource();
            int[] coordenadas = pegaCoordenadas(botãoClicado);   int linhaMatriz = coordenadas[0];   int colunaMatriz = coordenadas[1];
            System.out.println("Linha: " + linhaMatriz + " Coluna: " + colunaMatriz);
        
            atualizaCorBotao(botãoClicado, GREEN);
            if (ultimoBotãoClicado != null && !ultimoBotãoClicado.equals(botãoClicado)) {
                atualizaCorBotao (ultimoBotãoClicado,null);
            }
            ultimoBotãoClicado = botãoClicado;
        }
    }//GEN-LAST:event_jButton10MouseClicked

    private void jButton11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseClicked
        if ( rodada == 1){
            JButton botãoClicado = (JButton) evt.getSource();
            int[] coordenadas = pegaCoordenadas(botãoClicado);
            if ( bombaSelecionada != null )
                colocaPeçaNoBotão(botãoClicado, bombaSelecionada);
            else if ( bandeiraSelecionada != null )
                colocaPeçaNoBotão(botãoClicado, bandeiraSelecionada);
            else if ( espiãoSelecionado != null)
                colocaPeçaNoBotão(botãoClicado, espiãoSelecionado);
        }
        else if ( rodada == 2){
            JButton botãoClicado = (JButton) evt.getSource();
            int[] coordenadas = pegaCoordenadas(botãoClicado);   int linhaMatriz = coordenadas[0];   int colunaMatriz = coordenadas[1];
            System.out.println("Linha: " + linhaMatriz + " Coluna: " + colunaMatriz);
        
            atualizaCorBotao(botãoClicado, GREEN);
            if (ultimoBotãoClicado != null && !ultimoBotãoClicado.equals(botãoClicado)) {
                atualizaCorBotao (ultimoBotãoClicado,null);
            }
            ultimoBotãoClicado = botãoClicado;
        }
    }//GEN-LAST:event_jButton11MouseClicked

    private void jButton13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton13MouseClicked
        if ( rodada == 1){
            JButton botãoClicado = (JButton) evt.getSource();
            int[] coordenadas = pegaCoordenadas(botãoClicado);
            if ( bombaSelecionada != null )
                colocaPeçaNoBotão(botãoClicado, bombaSelecionada);
            else if ( bandeiraSelecionada != null )
                colocaPeçaNoBotão(botãoClicado, bandeiraSelecionada);
            else if ( espiãoSelecionado != null)
                colocaPeçaNoBotão(botãoClicado, espiãoSelecionado);
        }
        else if ( rodada == 2){
            JButton botãoClicado = (JButton) evt.getSource();
            int[] coordenadas = pegaCoordenadas(botãoClicado);   int linhaMatriz = coordenadas[0];   int colunaMatriz = coordenadas[1];
            System.out.println("Linha: " + linhaMatriz + " Coluna: " + colunaMatriz);
        
            atualizaCorBotao(botãoClicado, GREEN);
            if (ultimoBotãoClicado != null && !ultimoBotãoClicado.equals(botãoClicado)) {
                atualizaCorBotao (ultimoBotãoClicado,null);
            }
            ultimoBotãoClicado = botãoClicado;
        }
    }//GEN-LAST:event_jButton13MouseClicked

    private void jButton15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton15MouseClicked
        if ( rodada == 1){
            JButton buttonClicked = (JButton) evt.getSource();
            int[] coordinates = pegaCoordenadas(buttonClicked);
            if ( bombaSelecionada != null )
                colocaPeçaNoBotão(buttonClicked, bombaSelecionada);
            else if ( bandeiraSelecionada != null ){
                colocaPeçaNoBotão(buttonClicked, bandeiraSelecionada);
            }
        }
        else if ( rodada == 2){
            JButton buttonClicked = (JButton) evt.getSource();
            int[] coordinates = pegaCoordenadas(buttonClicked);   int row = coordinates[0];   int column = coordinates[1];
            System.out.println("Linha: " + row + " Coluna: " + column);
        
            atualizaCorBotao(buttonClicked, GREEN);
            if (ultimoBotãoClicado != null && !ultimoBotãoClicado.equals(buttonClicked)) {
                atualizaCorBotao (ultimoBotãoClicado,null);
            }
            ultimoBotãoClicado = buttonClicked;
        }
    }//GEN-LAST:event_jButton15MouseClicked

    private void jButton16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton16MouseClicked
        if ( rodada == 1){
            JButton botãoClicado = (JButton) evt.getSource();
            int[] coordenadas = pegaCoordenadas(botãoClicado);
            if ( bombaSelecionada != null )
                colocaPeçaNoBotão(botãoClicado, bombaSelecionada);
            else if ( bandeiraSelecionada != null )
                colocaPeçaNoBotão(botãoClicado, bandeiraSelecionada);
            else if ( espiãoSelecionado != null)
                colocaPeçaNoBotão(botãoClicado, espiãoSelecionado);
        }
        else if ( rodada == 2){
            JButton botãoClicado = (JButton) evt.getSource();
            int[] coordenadas = pegaCoordenadas(botãoClicado);   int linhaMatriz = coordenadas[0];   int colunaMatriz = coordenadas[1];
            System.out.println("Linha: " + linhaMatriz + " Coluna: " + colunaMatriz);
        
            atualizaCorBotao(botãoClicado, GREEN);
            if (ultimoBotãoClicado != null && !ultimoBotãoClicado.equals(botãoClicado)) {
                atualizaCorBotao (ultimoBotãoClicado,null);
            }
            ultimoBotãoClicado = botãoClicado;
        }
    }//GEN-LAST:event_jButton16MouseClicked

    private void jButton17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton17MouseClicked
        if ( rodada == 1){
            JButton botãoClicado = (JButton) evt.getSource();
            int[] coordenadas = pegaCoordenadas(botãoClicado);
            if ( bombaSelecionada != null )
                colocaPeçaNoBotão(botãoClicado, bombaSelecionada);
            else if ( bandeiraSelecionada != null )
                colocaPeçaNoBotão(botãoClicado, bandeiraSelecionada);
            else if ( espiãoSelecionado != null)
                colocaPeçaNoBotão(botãoClicado, espiãoSelecionado);
        }
        else if ( rodada == 2){
            JButton botãoClicado = (JButton) evt.getSource();
            int[] coordenadas = pegaCoordenadas(botãoClicado);   int linhaMatriz = coordenadas[0];   int colunaMatriz = coordenadas[1];
            System.out.println("Linha: " + linhaMatriz + " Coluna: " + colunaMatriz);
        
            atualizaCorBotao(botãoClicado, GREEN);
            if (ultimoBotãoClicado != null && !ultimoBotãoClicado.equals(botãoClicado)) {
                atualizaCorBotao (ultimoBotãoClicado,null);
            }
            ultimoBotãoClicado = botãoClicado;
        }
    }//GEN-LAST:event_jButton17MouseClicked

    private void jButton18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton18MouseClicked
        if ( rodada == 1){
            JButton botãoClicado = (JButton) evt.getSource();
            int[] coordenadas = pegaCoordenadas(botãoClicado);
            if ( bombaSelecionada != null )
                colocaPeçaNoBotão(botãoClicado, bombaSelecionada);
            else if ( bandeiraSelecionada != null )
                colocaPeçaNoBotão(botãoClicado, bandeiraSelecionada);
            else if ( espiãoSelecionado != null)
                colocaPeçaNoBotão(botãoClicado, espiãoSelecionado);
        }
        else if ( rodada == 2){
            JButton botãoClicado = (JButton) evt.getSource();
            int[] coordenadas = pegaCoordenadas(botãoClicado);   int linhaMatriz = coordenadas[0];   int colunaMatriz = coordenadas[1];
            System.out.println("Linha: " + linhaMatriz + " Coluna: " + colunaMatriz);
        
            atualizaCorBotao(botãoClicado, GREEN);
            if (ultimoBotãoClicado != null && !ultimoBotãoClicado.equals(botãoClicado)) {
                atualizaCorBotao (ultimoBotãoClicado,null);
            }
            ultimoBotãoClicado = botãoClicado;
        }
    }//GEN-LAST:event_jButton18MouseClicked

    private void jButton19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton19MouseClicked
        if ( rodada == 1){
            JButton botãoClicado = (JButton) evt.getSource();
            int[] coordenadas = pegaCoordenadas(botãoClicado);
            if ( bombaSelecionada != null )
                colocaPeçaNoBotão(botãoClicado, bombaSelecionada);
            else if ( bandeiraSelecionada != null )
                colocaPeçaNoBotão(botãoClicado, bandeiraSelecionada);
            else if ( espiãoSelecionado != null)
                colocaPeçaNoBotão(botãoClicado, espiãoSelecionado);
        }
        else if ( rodada == 2){
            JButton botãoClicado = (JButton) evt.getSource();
            int[] coordenadas = pegaCoordenadas(botãoClicado);   int linhaMatriz = coordenadas[0];   int colunaMatriz = coordenadas[1];
            System.out.println("Linha: " + linhaMatriz + " Coluna: " + colunaMatriz);
        
            atualizaCorBotao(botãoClicado, GREEN);
            if (ultimoBotãoClicado != null && !ultimoBotãoClicado.equals(botãoClicado)) {
                atualizaCorBotao (ultimoBotãoClicado,null);
            }
            ultimoBotãoClicado = botãoClicado;
        }
    }//GEN-LAST:event_jButton19MouseClicked

    private void jButton20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton20MouseClicked
        if ( rodada == 1){
            JButton botãoClicado = (JButton) evt.getSource();
            int[] coordenadas = pegaCoordenadas(botãoClicado);
            if ( bombaSelecionada != null )
                colocaPeçaNoBotão(botãoClicado, bombaSelecionada);
            else if ( bandeiraSelecionada != null )
                colocaPeçaNoBotão(botãoClicado, bandeiraSelecionada);
            else if ( espiãoSelecionado != null)
                colocaPeçaNoBotão(botãoClicado, espiãoSelecionado);
        }
        else if ( rodada == 2){
            JButton botãoClicado = (JButton) evt.getSource();
            int[] coordenadas = pegaCoordenadas(botãoClicado);   int linhaMatriz = coordenadas[0];   int colunaMatriz = coordenadas[1];
            System.out.println("Linha: " + linhaMatriz + " Coluna: " + colunaMatriz);
        
            atualizaCorBotao(botãoClicado, GREEN);
            if (ultimoBotãoClicado != null && !ultimoBotãoClicado.equals(botãoClicado)) {
                atualizaCorBotao (ultimoBotãoClicado,null);
            }
            ultimoBotãoClicado = botãoClicado;
        }
    }//GEN-LAST:event_jButton20MouseClicked

    private void jButton21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton21MouseClicked
        if ( rodada == 1){
            JButton botãoClicado = (JButton) evt.getSource();
            int[] coordenadas = pegaCoordenadas(botãoClicado);
            if ( bombaSelecionada != null )
                colocaPeçaNoBotão(botãoClicado, bombaSelecionada);
            else if ( bandeiraSelecionada != null )
                colocaPeçaNoBotão(botãoClicado, bandeiraSelecionada);
            else if ( espiãoSelecionado != null)
                colocaPeçaNoBotão(botãoClicado, espiãoSelecionado);
        }
        else if ( rodada == 2){
            JButton botãoClicado = (JButton) evt.getSource();
            int[] coordenadas = pegaCoordenadas(botãoClicado);   int linhaMatriz = coordenadas[0];   int colunaMatriz = coordenadas[1];
            System.out.println("Linha: " + linhaMatriz + " Coluna: " + colunaMatriz);
        
            atualizaCorBotao(botãoClicado, GREEN);
            if (ultimoBotãoClicado != null && !ultimoBotãoClicado.equals(botãoClicado)) {
                atualizaCorBotao (ultimoBotãoClicado,null);
            }
            ultimoBotãoClicado = botãoClicado;
        }
    }//GEN-LAST:event_jButton21MouseClicked

    private void jButton22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton22MouseClicked
        if ( rodada == 1){
            JButton botãoClicado = (JButton) evt.getSource();
            int[] coordenadas = pegaCoordenadas(botãoClicado);
            if ( bombaSelecionada != null )
                colocaPeçaNoBotão(botãoClicado, bombaSelecionada);
            else if ( bandeiraSelecionada != null )
                colocaPeçaNoBotão(botãoClicado, bandeiraSelecionada);
            else if ( espiãoSelecionado != null)
                colocaPeçaNoBotão(botãoClicado, espiãoSelecionado);
        }
        else if ( rodada == 2){
            JButton botãoClicado = (JButton) evt.getSource();
            int[] coordenadas = pegaCoordenadas(botãoClicado);   int linhaMatriz = coordenadas[0];   int colunaMatriz = coordenadas[1];
            System.out.println("Linha: " + linhaMatriz + " Coluna: " + colunaMatriz);
        
            atualizaCorBotao(botãoClicado, GREEN);
            if (ultimoBotãoClicado != null && !ultimoBotãoClicado.equals(botãoClicado)) {
                atualizaCorBotao (ultimoBotãoClicado,null);
            }
            ultimoBotãoClicado = botãoClicado;
        }
    }//GEN-LAST:event_jButton22MouseClicked

    private void jButton23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton23MouseClicked
        if ( rodada == 1){
            JButton botãoClicado = (JButton) evt.getSource();
            int[] coordenadas = pegaCoordenadas(botãoClicado);
            if ( bombaSelecionada != null )
                colocaPeçaNoBotão(botãoClicado, bombaSelecionada);
            else if ( bandeiraSelecionada != null )
                colocaPeçaNoBotão(botãoClicado, bandeiraSelecionada);
            else if ( espiãoSelecionado != null)
                colocaPeçaNoBotão(botãoClicado, espiãoSelecionado);
        }
        else if ( rodada == 2){
            JButton botãoClicado = (JButton) evt.getSource();
            int[] coordenadas = pegaCoordenadas(botãoClicado);   int linhaMatriz = coordenadas[0];   int colunaMatriz = coordenadas[1];
            System.out.println("Linha: " + linhaMatriz + " Coluna: " + colunaMatriz);
        
            atualizaCorBotao(botãoClicado, GREEN);
            if (ultimoBotãoClicado != null && !ultimoBotãoClicado.equals(botãoClicado)) {
                atualizaCorBotao (ultimoBotãoClicado,null);
            }
            ultimoBotãoClicado = botãoClicado;
        }
    }//GEN-LAST:event_jButton23MouseClicked

    private void jButton24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton24MouseClicked
        if ( rodada == 1){
            JButton botãoClicado = (JButton) evt.getSource();
            int[] coordenadas = pegaCoordenadas(botãoClicado);
            if ( bombaSelecionada != null )
                colocaPeçaNoBotão(botãoClicado, bombaSelecionada);
            else if ( bandeiraSelecionada != null )
                colocaPeçaNoBotão(botãoClicado, bandeiraSelecionada);
            else if ( espiãoSelecionado != null)
                colocaPeçaNoBotão(botãoClicado, espiãoSelecionado);
        }
        else if ( rodada == 2){
            JButton botãoClicado = (JButton) evt.getSource();
            int[] coordenadas = pegaCoordenadas(botãoClicado);   int linhaMatriz = coordenadas[0];   int colunaMatriz = coordenadas[1];
            System.out.println("Linha: " + linhaMatriz + " Coluna: " + colunaMatriz);
        
            atualizaCorBotao(botãoClicado, GREEN);
            if (ultimoBotãoClicado != null && !ultimoBotãoClicado.equals(botãoClicado)) {
                atualizaCorBotao (ultimoBotãoClicado,null);
            }
            ultimoBotãoClicado = botãoClicado;
        }
    }//GEN-LAST:event_jButton24MouseClicked

    private void jButton25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton25MouseClicked
        if ( rodada == 1){
            JButton botãoClicado = (JButton) evt.getSource();
            int[] coordenadas = pegaCoordenadas(botãoClicado);
            if ( bombaSelecionada != null )
                colocaPeçaNoBotão(botãoClicado, bombaSelecionada);
            else if ( bandeiraSelecionada != null )
                colocaPeçaNoBotão(botãoClicado, bandeiraSelecionada);
            else if ( espiãoSelecionado != null)
                colocaPeçaNoBotão(botãoClicado, espiãoSelecionado);
        }
        else if ( rodada == 2){
            JButton botãoClicado = (JButton) evt.getSource();
            int[] coordenadas = pegaCoordenadas(botãoClicado);   int linhaMatriz = coordenadas[0];   int colunaMatriz = coordenadas[1];
            System.out.println("Linha: " + linhaMatriz + " Coluna: " + colunaMatriz);
        
            atualizaCorBotao(botãoClicado, GREEN);
            if (ultimoBotãoClicado != null && !ultimoBotãoClicado.equals(botãoClicado)) {
                atualizaCorBotao (ultimoBotãoClicado,null);
            }
            ultimoBotãoClicado = botãoClicado;
        }
    }//GEN-LAST:event_jButton25MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        if ( rodada == 1){
            JButton botãoClicado = (JButton) evt.getSource();
            int[] coordenadas = pegaCoordenadas(botãoClicado);
            if ( bombaSelecionada != null )
                colocaPeçaNoBotão(botãoClicado, bombaSelecionada);
            else if ( bandeiraSelecionada != null )
                colocaPeçaNoBotão(botãoClicado, bandeiraSelecionada);
            else if ( espiãoSelecionado != null)
                colocaPeçaNoBotão(botãoClicado, espiãoSelecionado);
        }
        else if ( rodada == 2){
            JButton botãoClicado = (JButton) evt.getSource();
            int[] coordenadas = pegaCoordenadas(botãoClicado);   int linhaMatriz = coordenadas[0];   int colunaMatriz = coordenadas[1];
            System.out.println("Linha: " + linhaMatriz + " Coluna: " + colunaMatriz);
        
            atualizaCorBotao(botãoClicado, GREEN);
            if (ultimoBotãoClicado != null && !ultimoBotãoClicado.equals(botãoClicado)) {
                atualizaCorBotao (ultimoBotãoClicado,null);
            }
            ultimoBotãoClicado = botãoClicado;
        }
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButtonPeça1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonPeça1MouseClicked
        if ( bombasUsadas < 3){
            bombaSelecionada = new Bomba("Bomba", 1, new int[]{, });
            peçaSelecionada = bombaSelecionada;
            jConsole.append("Bomba selecionada\n");
        } else {
            jConsole.append("Não é possivel mais selecionar uma Bomba\n");
        }
    }//GEN-LAST:event_jButtonPeça1MouseClicked

    private void jButtonPeça2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonPeça2MouseClicked
        if ( bandeiraEstáPosicionada == false){
            bandeiraSelecionada = new Bandeira("Bandeira", 1, new int[]{, });
            peçaSelecionada = bandeiraSelecionada;
            jConsole.append("Bandeira selecionada\n");
        } else {
            jConsole.append("Não é possivel mais selecionar uma Bandeira\n");
        }
    }//GEN-LAST:event_jButtonPeça2MouseClicked

    private void jButton26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton26MouseClicked
        imprimeMatriz(matrizTabuleiro);
    }//GEN-LAST:event_jButton26MouseClicked

    private void jButtonPeça3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonPeça3MouseClicked
        if ( espiãoUsado == false){
            espiãoSelecionado = new Espião("Bandeira", 1, new int[]{, });
            peçaSelecionada = espiãoSelecionado;
            jConsole.append("Espião selecionado\n");
        } else {
            jConsole.append("Não é possivel mais selecionar uma Bandeira\n");
        }
    }//GEN-LAST:event_jButtonPeça3MouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Board().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButtonPeça1;
    private javax.swing.JButton jButtonPeça2;
    private javax.swing.JButton jButtonPeça3;
    private javax.swing.JButton jButtonPeça4;
    private javax.swing.JButton jButtonPeça5;
    private javax.swing.JTextArea jConsole;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
