/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainstrategygame;

/**
 *
 * @author jvlai
 */
public class Vazio extends Peça {
    private boolean vazio;
    
    public Vazio (){
        this.vazio = true;
    }
    
    public boolean isVazio()
    {
        return this.vazio;
    }
}
