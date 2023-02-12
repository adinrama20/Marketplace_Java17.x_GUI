package adin.rama.form.login.subset;

import java.util.ArrayList;
import java.util.List;

public class ListBarang {
    private static List<Barang> listBarang;

    public ListBarang() {
        listBarang = new ArrayList<Barang>();
        listBarang.add(new Barang("Pensil", 2000, 10));
        listBarang.add(new Barang("Pulpen", 3000, 17));
        listBarang.add(new Barang("Sabun", 3500, 10));
        listBarang.add(new Barang("Shampo", 1000, 20));
        listBarang.add(new Barang("Gunting", 5000, 6));
        listBarang.add(new Barang("Baju", 20000, 5));
        listBarang.add(new Barang("Celana", 25000, 3));
        listBarang.add(new Barang("Setip", 500, 8));
        listBarang.add(new Barang("Sapu", 6500, 7));
        listBarang.add(new Barang("Kacamata", 5000, 5));
        listBarang.add(new Barang("Mouse", 50000, 6));
        listBarang.add(new Barang("Mousepad", 12000, 7));
    }

    public static void cekNull() {
        if (listBarang == null) new ListBarang();
    }

    public static List<Barang> getListBarang() {
        cekNull();
        return ListBarang.listBarang;
    }
}
