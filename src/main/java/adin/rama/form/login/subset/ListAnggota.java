package adin.rama.form.login.subset;

import java.util.ArrayList;
import java.util.List;

public class ListAnggota {
    private static List<Anggota> listAnggota;

    public ListAnggota() {
        listAnggota = new ArrayList<Anggota>();
        listAnggota.add(new Anggota("rama"));
        listAnggota.add(new Anggota("ella"));
        listAnggota.add(new Anggota("bahru"));
        listAnggota.add(new Anggota("jamal"));
    }

    public static void cekNull() {
        if (listAnggota == null) new ListAnggota();
    }

    public static List<Anggota> getListAnggota() {
        cekNull();
        return ListAnggota.listAnggota;
    }

    public static String getIdAnggota(String a) {
        cekNull();
        for (Anggota anggota : listAnggota) {
            if (anggota.getNama().equals(a)) {
                return anggota.getId();
            }
        }
        return null;
    }

    public static void tambahAnggota(String nama) {
        cekNull();
        listAnggota.add(new Anggota(nama));
    }
}
