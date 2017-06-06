/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studyjavaswing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author HM
 */
public class Home extends JFrame  {

    private Player player;

    private JPanel Jpn_main;
    private JLabel statusLabel;
    private JMenu menu1, menu2, view, profile;
    private JMenuBar menu;
    private JMenuItem newpr, newfl, openprj, openrprj, cloprj, prff;
    private JMenuItem selectAll;
    private JRadioButtonMenuItem Rdo_option;
    private JPopupMenu.Separator jSeparator1;
    private JButton stop, pause, play;
    public JFileChooser fileDialog = new JFileChooser();
    Mp3play mp3 =new Mp3play();
    Home() {
        initComponent();
    }

    private void initComponent() {

        Jpn_main = new JPanel();

        menu = new JMenuBar();
        menu1 = new JMenu();
        menu2 = new JMenu();
        profile = new JMenu();
        prff = new JMenuItem();
        view = new JMenu();
        jSeparator1 = new JPopupMenu.Separator();

        menu1.setText("File");
        newpr = new JMenuItem("New project");
        menu1.add(newpr);
        newfl = new JMenuItem("New file...");
        menu1.add(newfl);
        menu1.add(jSeparator1);
        openprj = new JMenuItem("Open Mp3");
        openprj.setActionCommand("OpenMp3");
        menu1.add(openprj);
        openrprj = new JMenuItem("Open Recent project");
        menu1.add(openrprj);
        cloprj = new JMenuItem("Close project");
        menu1.add(cloprj);
        cloprj = new JMenuItem("Open Recent project");
        menu1.add(cloprj);
        menu.add(menu1);

        menu2.setText("Edit");
        selectAll = new JMenuItem("Select all");
        menu2.add(selectAll);
        menu.add(menu2);

        view.setText("View");
        menu.add(view);

        profile.setText("Profile");
        prff.setText("Profile File");
        profile.add(prff);
        menu.add(profile);
        stop = new JButton("Stop");
        stop.setActionCommand("stopmp3");
        stop.setBounds(45, 60, 60, 25);
        pause = new JButton("Pause");
        pause.setBounds(45, 180, 60, 25);
        play = new JButton("Play");
        play.setActionCommand("playmp3");
        play.setBounds(45, 120, 60, 25);
        this.add(stop);
        this.add(play);

        Jpn_main.setLocation(0, 0);
        this.setJMenuBar(menu);
        this.add(Jpn_main);
        addListener();

    }

    private void addListener() {
        openprj.addActionListener(new CustomActionListener());
        play.addActionListener(new CustomActionListener());
        stop.addActionListener(new CustomActionListener());
    }

    private void OpenMp3() {
        final JFileChooser fileDialog = new JFileChooser();

      
                JFrame jfc = new JFrame();
                       jfc.setSize(500,500);
                int returnVal = fileDialog.showOpenDialog(jfc);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    java.io.File file = fileDialog.getSelectedFile();

                    System.out.println(file.getName());

                   
                    mp3.setPath(file.getPath());
                } else {
                    statusLabel.setText("Open command cancelled by user.");
                }

          
    }

    private class CustomActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("OpenMp3")) {
                OpenMp3();
            }
             if (command.equals("playmp3")) {
                 mp3.start();
            }
              if (command.equals("stopmp3")) {
                 
            mp3.stopmp3();
            }
        }

    }

    public static void main(String[] args) {
        Home h = new Home();
        h.setVisible(true);
        h.setSize(500, 500);
    }
}
