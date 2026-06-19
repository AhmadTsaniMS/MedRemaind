/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package medremind;

/**
 *
 * @author Ahmad Tsani
 */
import java.io.*;
import java.util.*;

// 1. Interface [cite: 34]
interface OperasiObat {
    void simpanKeFile();
    void bacaDariFile();
}

// 2. Class, Atribut, Encapsulation [cite: 22, 23, 25]
abstract class Obat {
    private String nama;
    private int stok;

    // 3. Constructor & Overloading [cite: 24, 29, 30]
    public Obat() {
        this.nama = "Belum ada nama";
        this.stok = 0;
    }

    public Obat(String nama, int stok) {
        this.nama = nama;
        this.stok = stok;
    }

    // Encapsulation (Getter & Setter) [cite: 25]
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public int getStok() { return stok; }
    public void setStok(int stok) { this.stok = stok; }

    // Persiapan Polymorphism [cite: 26]
    public abstract void infoObat();
}

// 4. Inheritance & Polymorphism [cite: 26]
class ObatPribadi extends Obat implements OperasiObat {
    private final String jadwalMinum;

    public ObatPribadi(String nama, int stok, String jadwalMinum) {
        super(nama, stok); // Memanggil constructor superclass
        this.jadwalMinum = jadwalMinum;
    }

    // Polymorphism (Override) [cite: 26]
    @Override
    public void infoObat() {
        System.out.println("Nama Obat: " + getNama() + " | Stok: " + getStok() + " | Jadwal: " + jadwalMinum);
    }

    // 5. File Input Output (.txt) [cite: 43, 45, 48]
    @Override
    public void simpanKeFile() {
        try (FileWriter fw = new FileWriter("medremind_data.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(getNama() + "," + getStok() + "," + jadwalMinum);
        } catch (IOException e) {
            System.out.println("Error: File tidak dapat disimpan.");
        }
    }

    // 6. Membaca file & menangani Data Kosong / File tidak ditemukan [cite: 41, 42, 46]
    @Override
    public void bacaDariFile() {
        File file = new File("medremind_data.txt");
        if (!file.exists()) {
            System.out.println("Peringatan: File tidak ditemukan atau data masih kosong."); // [cite: 41, 42]
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String baris;
            System.out.println("\n--- Data Obat Tersimpan ---");
            boolean adaData = false;
            while ((baris = br.readLine()) != null) {
                String[] data = baris.split(",");
                if(data.length == 3) {
                     System.out.println("Obat: " + data[0] + " | Stok: " + data[1] + " | Jadwal: " + data[2]);
                     adaData = true;
                }
            }
            if (!adaData) {
                System.out.println("Data obat kosong."); // [cite: 42]
            }
        } catch (IOException e) {
            System.out.println("Error membaca file: " + e.getMessage());
        }
    }
}

public class MedRemind {

    /**
     * @param args the command line arguments
     */
public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
        ObatPribadi pengelola = new ObatPribadi("", 0, ""); // Dummy object untuk akses method baca
        boolean lanjut = true;

        System.out.println("=== MedRemind: Sistem Manajemen Stok Obat Pribadi ===");

        // Dasar Pemrograman: Perulangan [cite: 18]
        while (lanjut) {
            System.out.println("\nMenu Utama:");
            System.out.println("1. Tambah Obat & Jadwal Baru");
            System.out.println("2. Lihat Data Obat (Dari File)");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");

            // Exception Handling & Validasi Error Input Angka [cite: 37, 38, 40]
            try { 
                int pilihan = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                // Dasar Pemrograman: Percabangan [cite: 17]
                switch (pilihan) {
                    case 1 -> {
                        System.out.print("Masukkan Nama Obat: ");
                        String nama = scanner.nextLine();
                        System.out.print("Masukkan Jumlah Stok (Angka): ");
                        int stok = scanner.nextInt(); // Bisa memicu InputMismatchException
                        scanner.nextLine(); // Consume newline
                        System.out.print("Masukkan Jadwal Minum (contoh: 3x Sehari sesudah makan): ");
                        String jadwal = scanner.nextLine();

                        ObatPribadi obatBaru = new ObatPribadi(nama, stok, jadwal);
                        System.out.println("\nBerhasil ditambahkan:");
                        obatBaru.infoObat();
                        obatBaru.simpanKeFile();
                    }
                    case 2 -> pengelola.bacaDariFile();
                    case 3 -> {
                        lanjut = false;
                        System.out.println("Terima kasih telah menggunakan MedRemind!");
                    }
                    default -> System.out.println("Pilihan tidak valid, masukkan angka 1-3.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Input tidak valid! Pastikan Anda memasukkan format angka yang benar."); // [cite: 38, 40]
                scanner.nextLine(); // Membersihkan buffer scanner agar tidak infinite loop
            }
        }
    } // Dummy object untuk akses method baca
    }
    
}
