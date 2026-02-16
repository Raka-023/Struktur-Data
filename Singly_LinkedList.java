import java.util.Scanner;

public class Singly_LinkedList {

    static class Node {
        String nim;
        String nama;
        Node next;

        Node(String nim, String nama) {
            this.nim = nim;
            this.nama = nama;
            this.next = null;
        }
    }

    static Node head = null;

     static void insertBeginning(String nim, String nama) {
        Node newNode = new Node(nim, nama);
        newNode.next = head;
        head = newNode;
        System.out.println("!!DATA BERHASIL DISIMPAN!!");
    }

    static void insertPos(int pos, String nim, String nama) {

        if (pos < 1){
        System.out.println("!!POSISI TIDAK VALID!!");
            return;
        }

        if (pos == 1) {
            Node newNode = new Node(nim, nama);
            newNode.next = head;
            head = newNode;
            return;
        }

        Node curr = head;

    
        for (int i = 1; i < pos - 1 && curr != null; i++) {
            curr = curr.next;
        }

       
        if (curr == null)
            return;

        Node newNode = new Node(nim, nama);

        newNode.next = curr.next;
        curr.next = newNode;
         System.out.println("!!DATA BERHASIL DISIMPAN!!");
        return;
    }

     static void insertEnd(String nim, String nama) {
      
        Node newNode = new Node(nim, nama);

        if (head == null) {
            head = newNode;
        System.out.println("!!DATA BERHASIL DISIMPAN!!");
            return;
        }

        Node last = head;

        while (last.next != null) {
            last = last.next;
        }

        last.next = newNode;

         System.out.println("!!DATA BERHASIL DISIMPAN!!");

        return;
    }

    static void deleteBeginning() {

        if (head == null){
        System.out.println("!!DAFTAR KOSONG!!");
            return;
        }

        head = head.next;
         System.out.println("!!DATA BERHASIL DIHAPUS!!");

        return;
    }

    static void deletePos(int pos) {
        Node temp = head;

        if (head == null || pos < 1){
        System.out.println("!!DATA TIDAK DITEMUKAN!!");
        return;
        }

        if (pos== 1) {
            head = temp.next;
         System.out.println("!!DATA BERHASIL DIHAPUS!!");
            return;
        }

        Node prev = null;
        for (int i = 1; i < pos && temp != null; i++) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) return;

        prev.next = temp.next;
        System.out.println("!!DATA BERHASIL DIHAPUS!!");
    }

    static void deleteEnd() {
     
        if (head == null) {
        System.out.println("!!DAFTAR KOSONG!!");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }
        
        Node secondLast = head;
        while (secondLast.next.next != null) {
            secondLast = secondLast.next;
        }

    
        secondLast.next = null;
        System.out.println("!!DATA BERHASIL DIHAPUS!!");
    }

    static void deleteFirstOccurrence(String nim) {

    if (head == null){
    System.out.println("!!DAFTAR KOSONG!!");
    return;
    }

    if (head.nim.equals(nim)) {
        head = head.next;
        return;
    }

    Node curr = head;

    while (curr.next != null && !curr.next.nim.equals(nim)) {
        curr = curr.next;
    }

    if (curr.next != null) {
        curr.next = curr.next.next;
    System.out.println("!!DATA BERHASIL DIHAPUS!!");
    }
    
}

static void show() {

    if (head == null) {
        System.out.println("!!DAFTAR KOSONG!!");
        return;
    }
    System.out.println("==DAFTAR MAHASISWA==");

    Node temp = head;
    int i = 0;

    while (temp != null) {
        
        System.out.println(i + ". " + temp.nim + " | " + temp.nama);
        temp = temp.next;
        i++;
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

    if(choice == 1){
        System.out.print("NIM: ");
        String nim = sc.nextLine();

        System.out.print("Nama: ");
        String nama = sc.nextLine();

        insertBeginning(nim, nama);
    }

    else if(choice == 2){
        System.out.print("Posisi: ");
        int pos = sc.nextInt();
        sc.nextLine();

        System.out.print("NIM: ");
        String nim = sc.nextLine();

        System.out.print("Nama: ");
        String nama = sc.nextLine();

        insertPos(pos, nim, nama);
    }

    else if(choice == 3){
        System.out.print("NIM: ");
        String nim = sc.nextLine();

        System.out.print("Nama: ");
        String nama = sc.nextLine();

        insertEnd(nim, nama);
    }

    else if(choice == 4){
        deleteBeginning();
    }

    else if(choice == 5){
        System.out.print("Posisi: ");
        int pos = sc.nextInt();
        sc.nextLine();

        deletePos(pos);
    }

    else if(choice == 6){
        deleteEnd();
    }

    else if(choice == 7){
        System.out.print("NIM: ");
        String nim = sc.nextLine();
        deleteFirstOccurrence(nim);
    }

    else if(choice == 8){
        show();
    }

    else if(choice == 9){
        System.out.println("!!PROGRAM DIAKHIRI!!");
        break;
    }

        }
    }

}
