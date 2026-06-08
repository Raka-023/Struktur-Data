def input_matrix():
    rows = int(input("Masukkan jumlah baris: "))
    cols = int(input("Masukkan jumlah kolom: "))

    matrix = []
    print("Masukkan elemen matrix:")
    for i in range(rows):
        row = list(map(int, input(f"Baris {i+1}: ").split()))
        while len(row) != cols:
            print(f"Jumlah elemen harus {cols}")
            row = list(map(int, input(f"Baris {i+1}: ").split()))
        matrix.append(row)

    return matrix


def print_matrix(matrix):
    print("\nMatrix:")
    for row in matrix:
        print(*row)
    print()


def sort_row_wise(matrix):
    return [sorted(row) for row in matrix]


def sort_column_wise(matrix):
    rows = len(matrix)
    cols = len(matrix[0])

    result = [row[:] for row in matrix]

    for j in range(cols):
        col = [matrix[i][j] for i in range(rows)]
        col.sort()

        for i in range(rows):
            result[i][j] = col[i]

    return result


def rotate_clockwise_by_one(matrix):
    rows = len(matrix)
    cols = len(matrix[0])

    if rows < 2 or cols < 2:
        return matrix

    result = [row[:] for row in matrix]

    temp = matrix[1][0]

    for i in range(cols):
        result[0][i], temp = temp, result[0][i]

    for i in range(1, rows):
        result[i][cols-1], temp = temp, result[i][cols-1]

    for i in range(cols-2, -1, -1):
        result[rows-1][i], temp = temp, result[rows-1][i]

    for i in range(rows-2, -1, -1):
        result[i][0], temp = temp, result[i][0]

    return result


def rotate_counter_clockwise_by_one(matrix):
    rows = len(matrix)
    cols = len(matrix[0])

    if rows < 2 or cols < 2:
        return matrix

    result = [row[:] for row in matrix]

    temp = matrix[0][1]

    for i in range(rows):
        result[i][0], temp = temp, result[i][0]

    for i in range(1, cols):
        result[rows-1][i], temp = temp, result[rows-1][i]


    for i in range(rows-2, -1, -1):
        result[i][cols-1], temp = temp, result[i][cols-1]

    for i in range(cols-2, -1, -1):
        result[0][i], temp = temp, result[0][i]

    return result


def rotate_90(matrix):
    return [list(row) for row in zip(*matrix[::-1])]


def rotate_180(matrix):
    return [row[::-1] for row in matrix[::-1]]


def row_wise_traversal(matrix):
    print("Row-wise Traversal:")
    for row in matrix:
        for item in row:
            print(item, end=" ")
    print()


def column_wise_traversal(matrix):
    print("Column-wise Traversal:")
    rows = len(matrix)
    cols = len(matrix[0])

    for j in range(cols):
        for i in range(rows):
            print(matrix[i][j], end=" ")
    print()


def spiral_print(matrix):
    print("Spiral Traversal:")

    top = 0
    bottom = len(matrix) - 1
    left = 0
    right = len(matrix[0]) - 1

    while top <= bottom and left <= right:

        for i in range(left, right + 1):
            print(matrix[top][i], end=" ")
        top += 1

        for i in range(top, bottom + 1):
            print(matrix[i][right], end=" ")
        right -= 1

        if top <= bottom:
            for i in range(right, left - 1, -1):
                print(matrix[bottom][i], end=" ")
            bottom -= 1

        if left <= right:
            for i in range(bottom, top - 1, -1):
                print(matrix[i][left], end=" ")
            left += 1

    print()


def transpose(matrix):
    return [list(row) for row in zip(*matrix)]


matrix = input_matrix()

while True:
    print("\n========== MENU ==========")
    print("1-a. Sort the matrix row-wise")
    print("1-b. Sort the matrix column-wise")
    print("2-a. Rotate Matrix Clockwise by 1")
    print("2-b. Rotate Matrix Counter-Clockwise by 1")
    print("2-c. Rotate a matrix by 90")
    print("2-d. Rotate a matrix by 180")
    print("3-a. Row-wise traversal of matrix")
    print("3-b. Column-wise traversal of matrix")
    print("4. Print matrix in spiral form")
    print("5. Transpose matrix")
    print("6. Quit")

    choice = input("\nPilih menu: ").lower()

    if choice == "1-a":
        print_matrix(sort_row_wise(matrix))

    elif choice == "1-b":
        print_matrix(sort_column_wise(matrix))

    elif choice == "2-a":
        print_matrix(rotate_clockwise_by_one(matrix))

    elif choice == "2-b":
        print_matrix(rotate_counter_clockwise_by_one(matrix))

    elif choice == "2-c":
        print_matrix(rotate_90(matrix))

    elif choice == "2-d":
        print_matrix(rotate_180(matrix))

    elif choice == "3-a":
        row_wise_traversal(matrix)

    elif choice == "3-b":
        column_wise_traversal(matrix)

    elif choice == "4":
        spiral_print(matrix)

    elif choice == "5":
        print_matrix(transpose(matrix))

    elif choice == "6":
        print("Program selesai.")
        break

    else:
        print("Pilihan tidak valid!")