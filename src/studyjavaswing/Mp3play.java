/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studyjavaswing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;


public class Mp3play extends Thread{
    private Player player;
    private String path;

    public void setPath(String path) {
        this.path = path;
    }

    public void run(){
        try {
            player = new Player(new FileInputStream(path));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Mp3play.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JavaLayerException ex) {
            Logger.getLogger(Mp3play.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            player.play();
        } catch (JavaLayerException ex) {
            Logger.getLogger(Mp3play.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
   public void stopmp3(){
   
   player.close();
   }
}
