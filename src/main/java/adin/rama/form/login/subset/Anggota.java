package adin.rama.form.login.subset;

public class Anggota {
    private String nama;
    private String id;
    private static int autoIncrement = 1;

    public Anggota(String nama) {
        this.nama = nama;
        this.id = Integer.toString(autoIncrement++);
    }

    public Anggota() {}

    public String getNama() {
        return this.nama;
    }
    
    public String getId() {
        return this.id;
    }
}
