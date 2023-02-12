package adin.rama.form.login.core;

import adin.rama.form.login.subset.Barang;
import adin.rama.form.login.subset.ListBarang;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class HalBarang extends JFrame implements ActionListener {
    private JLabel daftarBarang;
    private JTable tabel;
    private DefaultTableModel model;
    private JScrollPane scrollPane;
    private JLabel inputBarang;
    private JTextField textInputBarang;
    private JLabel inputJumlah;
    private JTextField textInputJumlah;
    private JButton checkout;
    private JButton clear;
    private JButton exit;

    private Login login;

    public HalBarang() {
        daftarBarang = new JLabel("Daftar Barang:");
        daftarBarang.setBounds(35, 10, 350, 50);

        model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[] {
            "Nama Barang", "Harga", "Stok"
        });
        tabel = new JTable(model);

        int size = ListBarang.getListBarang().size();
        for (int i = 0; i < size; i++) {
            model.addRow(new Object[] {
                ListBarang.getListBarang().get(i).getNama(),
                ListBarang.getListBarang().get(i).getHarga(),
                ListBarang.getListBarang().get(i).getStok()
            });
        }

        scrollPane = new JScrollPane(tabel);
        scrollPane.setBounds(35, 55, 250, 215);

        inputBarang = new JLabel("Nama barang");
        inputBarang.setBounds(325, 55, 150, 25);

        textInputBarang = new JTextField();
        textInputBarang.setBounds(450, 60, 200, 20);

        inputJumlah = new JLabel("Jumlah barang");
        inputJumlah.setBounds(325, 85, 150, 25);

        textInputJumlah = new JTextField();
        textInputJumlah.setBounds(450, 90, 200, 20);

        checkout = new JButton("Checkout");
        checkout.setBounds(450, 115, 90, 25);

        clear = new JButton("Clear");
        clear.setBounds(450, 145, 90, 25);

        exit = new JButton("Exit");
        exit.setBounds(450, 175, 90, 25);

        checkout.addActionListener(this);
        checkout.setActionCommand("checkout");
        clear.addActionListener(this);
        clear.setActionCommand("clear");
        exit.addActionListener(this);
        exit.setActionCommand("exit");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch(command) {
            case "exit":
                login = new Login();
                login.show();
                break;
            case "checkout":
                String getBarang = textInputBarang.getText();
                String getJumlah = textInputJumlah.getText();
                int jumlah = Integer.parseInt(getJumlah);
                int i = 0;
                for (Barang barang : ListBarang.getListBarang()) {
                    if (getBarang.equalsIgnoreCase(barang.getNama())) {
                        if (jumlah <= ListBarang.getListBarang().get(i).getStok()) {
                            int harga = ListBarang.getListBarang().get(i).getHarga()*jumlah;
                            ListBarang.getListBarang().get(i).setStok(
                                ListBarang.getListBarang().get(i).getStok()-jumlah
                            );
                            JOptionPane.showMessageDialog(null, "Anda berhasil checkout dengan harga Rp " + harga + ",00");
                            JOptionPane.showMessageDialog(null, "Sisa stok " + ListBarang.getListBarang().get(i).getNama()
                            + " = " + ListBarang.getListBarang().get(i).getStok());
                            break;
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Anda gagal checkout karena stok terbatas");
                            break;
                        }
                    }
                    i++;
                }
                break;
            case "clear":
                textInputBarang.setText("");
                textInputJumlah.setText("");
                break;
        }
    }

    public void show() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame form = new JFrame("Halaman Belanja");
        form.setSize(810, 380);
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form.setLocationRelativeTo(null);
        form.setLayout(null);

        form.add(daftarBarang);
        form.add(scrollPane);
        form.add(inputBarang);
        form.add(textInputBarang);
        form.add(inputJumlah);
        form.add(textInputJumlah);
        form.add(checkout);
        form.add(clear);
        form.add(exit);

        form.setVisible(true);
    }
}
