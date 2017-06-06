/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studyjavaswing;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author HM
 */
public class Login extends JFrame {

    private JPanel pn_main;
    private JLabel lb_username;
    private JLabel lb_password;
    private JTextField tf_username;
    private JPasswordField pf_password;
    private JButton bt_login, bt_exit;
    JLabel lb_thongBao;
    private String account[][] = {{"admin", "admin"}, {"member", "member"}};

    Login() {
        init();
    }

    void init() {

        lb_username = new JLabel("Username");
        lb_username.setBounds(10, 10, 80, 25);
        lb_password = new JLabel("Password");
        lb_password.setBounds(10, 40, 80, 25);

        pf_password = new JPasswordField();
        tf_username = new JTextField();
        tf_username.setBounds(100, 10, 160, 25);
        pf_password.setBounds(100, 40, 160, 25);

        bt_login = new JButton("Đăng nhập");
        bt_exit = new JButton("Thoát");
        bt_exit.setActionCommand("exit");
        bt_login.setActionCommand("Login");
        bt_login.setBounds(10, 80, 100, 25);
        bt_exit.setBounds(180, 80, 80, 25);
        lb_thongBao = new JLabel();
        pn_main = new JPanel();
        pn_main.setLayout(null);
        pn_main.add(lb_username);
        pn_main.add(lb_password);
        pn_main.add(tf_username);
        pn_main.add(pf_password);
        pn_main.add(bt_login);
        pn_main.add(bt_exit);
        pn_main.add(lb_thongBao);
        this.add(pn_main);

        this.add(pn_main);
        event();
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

    }

    private void event() {
        bt_login.addActionListener(new ButtonClickListener());
        bt_exit.addActionListener(new ButtonClickListener());

    }

    private class ButtonClickListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("Login")) {
                login();
            } else if (command.equals("Exit")) {
                System.exit(1);
            }
        }

        private void login() {
            if (tf_username.getText().equals("") || pf_password.getText().equals("")) {

                lb_thongBao.setText("Username hoặc password trống!!!");
                lb_thongBao.setBounds(40, 101, 200, 25);
                lb_thongBao.setForeground(Color.red);
                pn_main.setVisible(true);

            } else {
                for (String tk[] : account) {
                    if (tf_username.getText().equals(tk[0]) && pf_password.getText().equals(tk[1])) {
                        Home home = new Home();
                        home.setSize(300, 200);
                        home.setVisible(true);
                        home.setLocation(550, 300);
                        dispose();
                    }

                }

            }
        }
    }

    public static void main(String[] args) {
        Login l = new Login();
        l.setSize(300, 200);
        l.setVisible(true);
        l.setLocation(550, 300);
    }

}
