MAX = 10

nim = [""] * MAX
nama = [""] * MAX
count = 0


def show():

    for i in range(count):
        print(f"{i}. {nim[i]} | {nama[i]}")


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

    # INSERT BEGINNING
    if choice == 1:

        if count == MAX:
            print("!ARRAY SUDAH PENUH!")
            continue

        for i in range(count, 0, -1):
            nim[i] = nim[i-1]
            nama[i] = nama[i-1]

        nim[0] = input("NIM: ")
        nama[0] = input("Nama: ")

        count += 1
        print("!!DATA BERHASIL DISIMPAN!!")

    # INSERT POSITION
    elif choice == 2:

        if count == MAX:
            print("!ARRAY SUDAH PENUH!")
            continue

        pos = int(input("Posisi: "))

        if pos < 0 or pos > count:
            print("Posisi tidak valid!")
            continue

        for i in range(count, pos, -1):
            nim[i] = nim[i-1]
            nama[i] = nama[i-1]

        nim[pos] = input("NIM: ")
        nama[pos] = input("Nama: ")

        count += 1
        print("!!DATA BERHASIL DISIMPAN!!")

    # INSERT END
    elif choice == 3:

        if count == MAX:
            print("!ARRAY SUDAH PENUH!")
            continue

        nim[count] = input("NIM: ")
        nama[count] = input("Nama: ")

        count += 1
        print("!!DATA BERHASIL DISIMPAN!!")

    # DELETE BEGINNING
    elif choice == 4:

        if count == 0:
            print("!!DATA MASIH KOSONG!!")
            continue

        for i in range(count-1):
            nim[i] = nim[i+1]
            nama[i] = nama[i+1]

        count -= 1
        print("!!DATA BERHASIL DIHAPUS!!")

    # DELETE POSITION
    elif choice == 5:

        if count == 0:
            print("!!DATA MASIH KOSONG!!")
            continue

        pos = int(input("Posisi: "))

        if pos < 0 or pos >= count:
            print("Posisi tidak valid!")
            continue

        for i in range(pos, count-1):
            nim[i] = nim[i+1]
            nama[i] = nama[i+1]

        count -= 1
        print("!!DATA BERHASIL DIHAPUS!!")

    # DELETE END
    elif choice == 6:

        if count == 0:
            print("!!DATA MASIH KOSONG!!")
            continue

        count -= 1
        print("!!DATA BERHASIL DIHAPUS!!")

    # DELETE FIRST OCCURRENCE
    elif choice == 7:

        if count == 0:
            print("!!DATA MASIH KOSONG!!")
            continue

        target = input("NIM: ")

        found = -1

        for i in range(count):
            if nim[i] == target:
                found = i
                break

        if found != -1:
            for i in range(found, count-1):
                nim[i] = nim[i+1]
                nama[i] = nama[i+1]

            count -= 1
            print("!!DATA BERHASIL DIHAPUS!!")
        else:
            print("NIM tidak ditemukan!")

    # SHOW
    elif choice == 8:
        show()

    # EXIT
    elif choice == 9:
        print("!!PROGRAM DIAKHIRI!!")
        break
