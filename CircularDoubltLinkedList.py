import time


class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
        self.prev = None


class CircularDoublyLinkedList:

    def __init__(self):
        self.head = None
        self.tail = None

    def insert(self, berita):

        newNode = Node(berita)

        if self.head is None:
            self.head = self.tail = newNode
            self.head.next = self.head
            self.head.prev = self.head
        else:
            self.tail.next = newNode
            newNode.prev = self.tail
            newNode.next = self.head
            self.head.prev = newNode
            self.tail = newNode

        print("Berita ditambahkan.")

    def delete(self, pos):

        if self.head is None:
            print("List kosong.")
            return

        temp = self.head
        count = 1

        while True:
            if count == pos:

                if temp == self.head and temp == self.tail:
                    self.head = self.tail = None
                else:
                    temp.prev.next = temp.next
                    temp.next.prev = temp.prev

                    if temp == self.head:
                        self.head = temp.next

                    if temp == self.tail:
                        self.tail = temp.prev

                print("Berita dihapus.")
                return

            temp = temp.next
            count += 1

            if temp == self.head:
                break

        print("Posisi tidak ditemukan.")

    def displayForward(self):

        if self.head is None:
            print("List kosong")
            return

        temp = self.head

        while True:
            print(temp.data)

            temp = temp.next

            if temp != self.head:
                time.sleep(3)
            else:
                break

    def displayBackward(self):

        if self.tail is None:
            print("Tidak ada berita.")
            return

        temp = self.tail

        while True:
            print(temp.data)

            temp = temp.prev

            if temp != self.tail:
                time.sleep(3)
            else:
                break

    def displayAt(self, pos):

        if self.head is None:
            print("List kosong.")
            return

        temp = self.head
        count = 1

        while True:
            if count == pos:
                print(temp.data)
                return

            temp = temp.next
            count += 1

            if temp == self.head:
                break

        print("Posisi tidak ditemukan.")


def main():

    lst = CircularDoublyLinkedList()

    while True:
        print("\n===== MENU =====")
        print("1. Insert Berita")
        print("2. Hapus Berita")
        print("3. Tampilkan Forward")
        print("4. Tampilkan Backward")
        print("5. Tampil Berita Tertentu")
        print("6. Exit")

        choice = int(input("Pilihan: "))

        if choice == 1:
            berita = input("Masukkan berita: ")
            lst.insert(berita)

        elif choice == 2:
            pos = int(input("Nomor berita: "))
            lst.delete(pos)

        elif choice == 3:
            print("\n=== Running Text Forward ===")
            lst.displayForward()

        elif choice == 4:
            print("\n=== Running Text Backward ===")
            lst.displayBackward()

        elif choice == 5:
            pos = int(input("Nomor berita: "))
            lst.displayAt(pos)

        elif choice == 6:
            print("Program selesai.")
            break

        else:
            print("Pilihan salah.")


if __name__ == "__main__":
    main()