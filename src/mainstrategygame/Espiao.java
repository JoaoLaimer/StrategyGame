/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainstrategygame;

/**
 *
 * @author vinic
 */
public class Espiao extends Peça {
    private boolean peçaEscondida;
    private boolean derrotaMarechal;
    private char tipo;
    
    public Espiao(){
        this.peçaEscondida   = true;
        this.derrotaMarechal = true;
        this.setNome("🕵");
    }
}
