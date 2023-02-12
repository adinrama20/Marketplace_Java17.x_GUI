package adin.rama.form.login.subset;

public class Barang {
    private String nama;
    private int harga;
    private int stok;

    public Barang(String nama, int harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public Barang() {};

    public String getNama() {
        return this.nama;
    }

    public int getHarga() {
        return this.harga;
    }

    public int getStok() {
        return this.stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
}
