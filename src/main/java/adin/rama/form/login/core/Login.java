package adin.rama.form.login.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import adin.rama.form.login.db_connection.StatementTest;

public class Login extends JFrame implements ActionListener {
    private JFrame form;
    private JLabel username;
    private JTextField textUsername;
    private JLabel id;
    private JTextField textId;
    private JButton login;
    private JButton daftar;

    private Daftar daftarkan;
    private HalBarang halBarang;

    public Login() {
        username = new JLabel("Username");
        username.setBounds(35, 25, 150, 25);

        textUsername = new JTextField();
        textUsername.setBounds(150, 30, 200, 20);

        id = new JLabel("ID");
        id.setBounds(35, 55, 150, 25);

        textId = new JTextField();
        textId.setBounds(150, 60, 200, 20);

        login = new JButton("Login");
        login.setBounds(150, 90, 70, 25);

        daftar = new JButton("Daftar");
        daftar.setBounds(150, 120, 70, 25);

        login.addActionListener(this);
        login.setActionCommand("login");
        daftar.addActionListener(this);
        daftar.setActionCommand("daftar");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch(command) {
            case "login":
                if (StatementTest.testExecuteQuery(textUsername.getText(), textId.getText()) == true) {
                    JOptionPane.showMessageDialog(null, "Anggota berhasil login");
                    halBarang = new HalBarang();
                    halBarang.show();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Anggota gagal login");
                }
                break;
            case "daftar":
                daftarkan = new Daftar();
                daftarkan.show();
                break;
        }
    }

    public void show() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        form = new JFrame("Halaman Login");
        form.setSize(810, 380);
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form.setLocationRelativeTo(null);
        form.setLayout(null);

        form.add(username);
        form.add(textUsername);
        form.add(id);
        form.add(textId);
        form.add(login);
        form.add(daftar);

        form.setVisible(true);
    }
}
