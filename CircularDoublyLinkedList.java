import java.util.Scanner;

class Node {
    String data;
    Node next, prev;

    Node(String data) {
        this.data = data;
    }
}

public class CircularDoublyLinkedList {

    Node head = null;
    Node tail = null;

    void insert(String berita) {

        Node newNode = new Node(berita);

        if (head == null) {
            head = tail = newNode;
            head.next = head;
            head.prev = head;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = head;
            head.prev = newNode;
            tail = newNode;
        }

        System.out.println("Berita ditambahkan.");
    }

    void delete(int pos) {

        if (head == null) {
            System.out.println("List kosong.");
            return;
        }

        Node temp = head;
        int count = 1;

        do {
            if (count == pos) {

                if (temp == head && temp == tail) {
                    head = tail = null;
                }
                else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;

                    if (temp == head)
                        head = temp.next;

                    if (temp == tail)
                        tail = temp.prev;
                }

                System.out.println("Berita dihapus.");
                return;
            }

            temp = temp.next;
            count++;

        } while (temp != head);

        System.out.println("Posisi tidak ditemukan.");
    }

    void displayForward() {

    if (head == null) {
        System.out.println("List kosong");
        return;
    }

    Node temp = head;

    do {
        System.out.println(temp.data);

        temp = temp.next;

        if (temp != head) { 
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    } while (temp != head);
}

    void displayBackward() {

    if (tail == null) {
        System.out.println("Tidak ada berita.");
        return;
    }

    Node temp = tail;

    do {
        System.out.println(temp.data);

        temp = temp.prev; 

        if (temp != tail) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    } while (temp != tail);
}

  void displayAt(int pos) {

    if (head == null) {
        System.out.println("List kosong.");
        return;
    }

    Node temp = head;
    int count = 1;

    do {
        if (count == pos) {
            System.out.println(temp.data);
            return;
        }

        temp = temp.next;
        count++;

    } while (temp != head);

    System.out.println("Posisi tidak ditemukan.");
}


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CircularDoublyLinkedList list =
                new CircularDoublyLinkedList();

        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Insert Berita");
            System.out.println("2. Hapus Berita");
            System.out.println("3. Tampilkan Forward");
            System.out.println("4. Tampilkan Backward");
            System.out.println("5. Tampil Berita Tertentu");
            System.out.println("6. Exit");

            System.out.print("Pilihan: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Masukkan berita: ");
                    String berita = sc.nextLine();
                    list.insert(berita);
                    break;

                case 2:
                    System.out.print("Nomor berita: ");
                    int del = sc.nextInt();
                    list.delete(del);
                    break;

                case 3:
                    System.out.println("\n=== Running Text Forward ===");
                    list.displayForward();
                    break;

                case 4:
                    System.out.println("\n=== Running Text Backward ===");
                    list.displayBackward();
                    break;

                case 5:
                    System.out.print("Nomor berita: ");
                    int pos = sc.nextInt();
                    list.displayAt(pos);
                    break;

                case 6:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan salah.");
            }

        } while (choice != 6);

        sc.close();
    }
}