class Node:
    def __init__(self, nim, nama):
        self.nim = nim
        self.nama = nama
        self.next = None


head = None


def insert_beginning(nim, nama):
    global head
    new_node = Node(nim, nama)
    new_node.next = head
    head = new_node
    print("!!DATA BERHASIL DISIMPAN!!")


def insert_pos(pos, nim, nama):
    global head

    if pos < 1:
        print("!!POSISI TIDAK VALID!!")
        return

    new_node = Node(nim, nama)

    if pos == 1:
        new_node.next = head
        head = new_node
        print("!!DATA BERHASIL DISIMPAN!!")
        return

    curr = head

    for _ in range(pos - 2):
        if curr is None:
            print("POSISI MELEBIHI PANJANG LIST")
            return
        curr = curr.next

    if curr is None:
        print("POSISI MELEBIHI PANJANG LIST")
        return

    new_node.next = curr.next
    curr.next = new_node
    print("!!DATA BERHASIL DISIMPAN!!")


def insert_end(nim, nama):
    global head
    new_node = Node(nim, nama)

    if head is None:
        head = new_node
        print("!!DATA BERHASIL DISIMPAN!!")
        return

    curr = head
    while curr.next:
        curr = curr.next

    curr.next = new_node
    print("!!DATA BERHASIL DISIMPAN!!")


def delete_beginning():
    global head
    if head is None:
        print("!!DAFTAR KOSONG!!")
        return

    head = head.next
    print("!!DATA BERHASIL DIHAPUS!!")


def delete_pos(pos):
    global head

    if head is None or pos < 1:
        print("!!DATA TIDAK DITEMUKAN!!")
        return

    if pos == 1:
        head = head.next
        print("!!DATA BERHASIL DIHAPUS!!")
        return

    curr = head
    prev = None

    for _ in range(pos - 1):
        prev = curr
        curr = curr.next
        if curr is None:
            print("!!DATA TIDAK DITEMUKAN!!")
            return

    prev.next = curr.next
    print("!!DATA BERHASIL DIHAPUS!!")


def delete_end():
    global head

    if head is None:
        print("!!DAFTAR KOSONG!!")
        return

    if head.next is None:
        head = None
        print("!!DATA BERHASIL DIHAPUS!!")
        return

    curr = head
    while curr.next.next:
        curr = curr.next

    curr.next = None
    print("!!DATA BERHASIL DIHAPUS!!")


def delete_first_occurrence(nim):
    global head

    if head is None:
        print("!!DAFTAR KOSONG!!")
        return

    if head.nim == nim:
        head = head.next
        print("!!DATA BERHASIL DIHAPUS!!")
        return

    curr = head

    while curr.next and curr.next.nim != nim:
        curr = curr.next

    if curr.next:
        curr.next = curr.next.next
        print("!!DATA BERHASIL DIHAPUS!!")
    else:
        print("NIM TIDAK DITEMUKAN")


def show():
    if head is None:
        print("!!DAFTAR KOSONG!!")
        return

    print("== DAFTAR MAHASISWA ==")
    temp = head
    i = 0

    while temp:
        print(f"{i}. {temp.nim} | {temp.nama}")
        temp = temp.next
        i += 1


while True:
    print("""
==================
 MENU PROGRAM
==================
1 Insert Beginning
2 Insert Position
3 Insert End
4 Delete Beginning
5 Delete Position
6 Delete End
7 Delete First Occurrence
8 Show
9 Exit
""")

    choice = int(input("Menu: "))

    if choice == 1:
        nim = input("NIM: ")
        nama = input("Nama: ")
        insert_beginning(nim, nama)

    elif choice == 2:
        pos = int(input("Posisi: "))
        nim = input("NIM: ")
        nama = input("Nama: ")
        insert_pos(pos, nim, nama)

    elif choice == 3:
        nim = input("NIM: ")
        nama = input("Nama: ")
        insert_end(nim, nama)

    elif choice == 4:
        delete_beginning()

    elif choice == 5:
        pos = int(input("Posisi: "))
        delete_pos(pos)

    elif choice == 6:
        delete_end()

    elif choice == 7:
        nim = input("NIM: ")
        delete_first_occurrence(nim)

    elif choice == 8:
        show()

    elif choice == 9:
        print("!!PROGRAM DIAKHIRI!!")
        break
