# MedRemind 
MedRemind adalah Sistem Manajemen Stok Obat Pribadi berbasis Java. Aplikasi ini dirancang untuk mencatat dan memantau ketersediaan obat pribadi beserta jadwal konsumsinya. Project ini sudah mencakup implementasi GUI dan CLI secara komprehensif.

📝 Deskripsi Proyek
MedRemind mendukung dua mode antarmuka: Command Line Interface (CLI) dan Graphical User Interface (GUI) yang dibangun menggunakan Java Swing. Semua data ketersediaan obat yang dimasukkan oleh pengguna akan disimpan secara persisten di dalam database lokal berupa file teks (medremind_data.txt), sehingga data tidak akan hilang meskipun program ditutup.

✨ Fitur Utama
Tambah Data Obat: Mencatat nama obat, jumlah ketersediaan (stok), dan jadwal minum (misal: 1x Sehari, 3x Sehari).
1. Tampil Data Obat: Menarik dan menampilkan daftar riwayat obat yang tersimpan di dalam memori lokal.
2. Penyimpanan Berbasis File (File I/O): Automasi penulisan dan pembacaan data menggunakan FileWriter, BufferedReader, dan PrintWriter.
3. Validasi Input (Exception Handling): Meminimalisir crash atau infinite loop melalui blok try-catch (InputMismatchException dan NumberFormatException) ketika user 4. salah memasukkan format data (misalnya menginput huruf pada kolom angka).

🛠️ Konsep OOP yang Diterapkan
Kode sumber dipecah dan disusun mengikuti standar Pemrograman Berorientasi Objek (PBO), meliputi:
1. Interface: OperasiObat untuk standarisasi fungsi simpanKeFile() dan bacaDariFile().
2. Abstract Class: Kelas Obat bertindak sebagai cetak biru (blueprint) utama.
3. Encapsulation: Penggunaan Access Modifier private untuk atribut dengan metode Getter dan Setter.
4. Inheritance: Kelas ObatPribadi mewarisi sifat dari superclass Obat.
5. Polymorphism & Overloading: Implementasi Constructor Overloading serta Method Overriding (@Override) pada fungsi spesifik seperti infoObat().

🖥️ Teknologi yang Digunakan
Bahasa: Java
Library GUI: javax.swing.* dan java.awt.*
Library I/O: java.io.*

🚀 Cara Menjalankan Aplikasi
Pastikan sistem kamu sudah terinstal Java Development Kit (JDK). Bisa dicoba langsung menggunakan Terminal (Linux/Ubuntu) maupun Command Prompt (Windows).

1. Menjalankan Versi CLI (Terminal)

Bash
# Lakukan kompilasi
javac medremind/MedRemind.java

# Jalankan program
java medremind.MedRemind

2. Menjalankan Versi GUI (Desktop)

Bash
# Lakukan kompilasi
javac medremind/MedRemindGUI.java

# Jalankan antarmuka visual
java medremind.MedRemindGUI
