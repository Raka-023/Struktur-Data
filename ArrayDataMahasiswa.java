import java.util.Scanner;

public class ArrayDataMahasiswa {

    static final int MAX = 10;
    static String[] nim = new String[MAX];
    static String[] nama = new String[MAX];
    static int count = 0;

    static void show() {
        for (int i = 0; i < count; i++) {
            System.out.println(i + " " + nim[i] + " | " + nama[i]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
        System.out.println();
        System.out.println("==================");
        System.out.println(" MENU PROGRAM");
        System.out.println("==================");
        System.out.println("""
1 Insert Beginning
2 Insert Position
3 Insert End
4 Delete Beginning
5 Delete Position
6 Delete End
7 Delete First Occurrence
8 Show
9 Exit
""");

            System.out.print("Menu: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                if (count == MAX) {
                    System.out.println("!ARRAY SUDAH PENUH!");
                    continue;
                }

                for (int i = count; i > 0; i--) {
                    nim[i] = nim[i-1];
                    nama[i] = nama[i-1];
                }

                System.out.print("NIM: ");
                nim[0] = sc.nextLine();
                System.out.print("Nama: ");
                nama[0] = sc.nextLine();

                count++;

            System.out.println("!!DATA BERHASIL DISIMPAN!!");

            }

            else if (choice == 2) {

            if (count == MAX) {
                    System.out.println("!ARRAY SUDAH PENUH!");
                    continue;
                }

            System.out.print("Posisi: ");
            int pos = sc.nextInt();
            sc.nextLine();

            if (pos < 0 || pos > count) {
                System.out.println("Posisi tidak valid!");
                continue;
            }

            for (int i = count; i > pos; i--) {
                nim[i] = nim[i-1];
                nama[i] = nama[i-1];
            }

            System.out.print("NIM: ");
            nim[pos] = sc.nextLine();

            System.out.print("Nama: ");
            nama[pos] = sc.nextLine();

            count++;

            System.out.println("!!DATA BERHASIL DISIMPAN!!");
        }


            else if (choice == 3) {

            if (count == MAX) {
                    System.out.println("!ARRAY SUDAH PENUH!");
                    continue;
                }

            System.out.print("NIM: ");
            nim[count] = sc.nextLine();
            System.out.print("Nama: ");
            nama[count] = sc.nextLine();

            count++;

            System.out.println("!!DATA BERHASIL DISIMPAN!!");

            }

            else if (choice == 4) {

                if (count == 0) {
                    System.out.println("!!DATA MASIH KOSONG!!");
                    continue;
                }

                for (int i = 0; i < count-1; i++) {
                    nim[i] = nim[i+1];
                    nama[i] = nama[i+1];
                }

                count--;
                System.out.println("!!DATA BERHASIL DIHAPUS!!");
            }

            else if (choice == 5) {

                if (count == 0) {
                    System.out.println("!!DATA MASIH KOSONG!!");
                    continue;
                }

                System.out.print("Posisi: ");
                int pos = sc.nextInt();

                for (int i = pos; i < count-1; i++) {
                    nim[i] = nim[i+1];
                    nama[i] = nama[i+1];
                }

                count--;
                System.out.println("!!DATA BERHASIL DIHAPUS!!");

            }

            else if (choice == 6) {

                if (count == 0) {
                    System.out.println("!!DATA MASIH KOSONG!!");
                    continue;
                }

                count--;

                System.out.println("!!DATA BERHASIL DIHAPUS!!");
            }

            else if (choice == 7) {

            if (count == 0) {
                    System.out.println("!!DATA MASIH KOSONG!!");
                    continue;
                }

            System.out.print("NIM: ");
            String target = sc.nextLine();

            int found = -1;

            for (int i = 0; i < count; i++) {
                if (nim[i].equals(target)) {
                    found = i;
                    break;
                }
            }

            if (found != -1) {

                for (int i = found; i < count-1; i++) {
                    nim[i] = nim[i+1];
                    nama[i] = nama[i+1];
                }

                count--;
                System.out.println("!!DATA BERHASIL DIHAPUS!!");

            } else {
                System.out.println("NIM tidak ditemukan!");
            }
        }

            else if (choice == 8) {
            System.out.println("== DATA MAHASISWA ==");
                show();
            }

            else if (choice == 9) {
            
            System.out.println("!!PROGRAM DIAKHIRI!!");
                break;
            }
        }
    }
}
