package adin.rama.form.login.core;

import adin.rama.form.login.db_connection.StatementTest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Daftar extends JFrame implements ActionListener {
    private JLabel halamanDaftar;
    private JLabel daftarUsername;
    private JTextField textDaftarUsername;
    private JButton daftarAkun;
    private JButton loginLagi;
    private Login login;

    public Daftar() {
        halamanDaftar = new JLabel("Daftar untuk login");
        halamanDaftar.setBounds(35, 10, 350, 50);

        daftarUsername = new JLabel("Username");
        daftarUsername.setBounds(35, 55, 150, 25);

        textDaftarUsername = new JTextField();
        textDaftarUsername.setBounds(150, 60, 200, 20);

        daftarAkun = new JButton("Daftarkan");
        daftarAkun.setBounds(150, 85, 90, 25);

        loginLagi = new JButton("Kembali login");
        loginLagi.setBounds(150, 115, 120, 25);

        daftarAkun.addActionListener(this);
        daftarAkun.setActionCommand("daftar");
        loginLagi.addActionListener(this);
        loginLagi.setActionCommand("login");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch(command) {
            case "login":
                login = new Login();
                login.show();
                break;
            case "daftar":
                String getUsername = textDaftarUsername.getText();
                if (StatementTest.testExecuteUpdate(getUsername) == true) {
                    JOptionPane.showMessageDialog(null, "Anggota berhasil ditambahkan dengan ID "
                    + StatementTest.testExecuteQueryId(getUsername));
                }
                else {
                    JOptionPane.showMessageDialog(null, "Nama anggota sudah ada");
                }
                break;
        }
    }

    /*private boolean cekAnggota(String a) {
        for (Anggota anggota : ListAnggota.getListAnggota()) {
            if (a.equals(anggota.getNama())) {
                return false;
            }
        }
        return true;
    }*/

    public void show() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame form = new JFrame("Halaman Pendaftaran");
        form.setSize(810, 380);
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form.setLocationRelativeTo(null);
        form.setLayout(null);

        form.add(halamanDaftar);
        form.add(daftarUsername);
        form.add(textDaftarUsername);
        form.add(daftarAkun);
        form.add(loginLagi);

        form.setVisible(true);
    }
}
