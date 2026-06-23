import java.util.*;

public class revisi_matrix {

    static Scanner input = new Scanner(System.in);

    public static int[][] inputMatrix() {
        System.out.print("Masukkan jumlah baris: ");
        int rows = input.nextInt();

        System.out.print("Masukkan jumlah kolom: ");
        int cols = input.nextInt();

        int[][] matrix = new int[rows][cols];

        System.out.println("Masukkan elemen matrix:");
        for (int i = 0; i < rows; i++) {
            System.out.println("Baris " + (i + 1) + ":");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = input.nextInt();
            }
        }

        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        System.out.println("\nMatrix:");
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static int[][] sortRowWise(int[][] matrix) {
        int[][] result = copyMatrix(matrix);

        for (int[] row : result) {
            Arrays.sort(row);
        }

        return result;
    }

    public static int[][] sortColumnWise(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] result = copyMatrix(matrix);

        for (int j = 0; j < cols; j++) {
            int[] col = new int[rows];

            for (int i = 0; i < rows; i++) {
                col[i] = result[i][j];
            }

            Arrays.sort(col);

            for (int i = 0; i < rows; i++) {
                result[i][j] = col[i];
            }
        }

        return result;
    }

    public static int[][] rotate90(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] result = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][rows - 1 - i] = matrix[i][j];
            }
        }

        return result;
    }

    public static int[][] rotate180(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[rows - 1 - i][cols - 1 - j] = matrix[i][j];
            }
        }

        return result;
    }

    public static int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] result = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }

    public static int[][] rotateClockwiseByOne(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (rows < 2 || cols < 2)
            return matrix;

        int[][] result = copyMatrix(matrix);

        int temp = matrix[1][0];

        for (int i = 0; i < cols; i++) {
            int current = result[0][i];
            result[0][i] = temp;
            temp = current;
        }

        for (int i = 1; i < rows; i++) {
            int current = result[i][cols - 1];
            result[i][cols - 1] = temp;
            temp = current;
        }

        for (int i = cols - 2; i >= 0; i--) {
            int current = result[rows - 1][i];
            result[rows - 1][i] = temp;
            temp = current;
        }

        for (int i = rows - 2; i >= 0; i--) {
            int current = result[i][0];
            result[i][0] = temp;
            temp = current;
        }

        return result;
    }

    public static int[][] rotateCounterClockwiseByOne(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (rows < 2 || cols < 2)
            return matrix;

        int[][] result = copyMatrix(matrix);

        int temp = matrix[0][1];

        for (int i = 0; i < rows; i++) {
            int current = result[i][0];
            result[i][0] = temp;
            temp = current;
        }

        for (int i = 1; i < cols; i++) {
            int current = result[rows - 1][i];
            result[rows - 1][i] = temp;
            temp = current;
        }

        for (int i = rows - 2; i >= 0; i--) {
            int current = result[i][cols - 1];
            result[i][cols - 1] = temp;
            temp = current;
        }

        for (int i = cols - 2; i >= 0; i--) {
            int current = result[0][i];
            result[0][i] = temp;
            temp = current;
        }

        return result;
    }

    public static void rowWiseTraversal(int[][] matrix) {
        System.out.println("Row-wise Traversal:");
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
        }
        System.out.println();
    }

    public static void columnWiseTraversal(int[][] matrix) {
        System.out.println("Column-wise Traversal:");

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows; i++) {
                System.out.print(matrix[i][j] + " ");
            }
        }

        System.out.println();
    }

    public static void spiralPrint(int[][] matrix) {
        System.out.println("Spiral Traversal:");

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {

            for (int i = left; i <= right; i++)
                System.out.print(matrix[top][i] + " ");
            top++;

            for (int i = top; i <= bottom; i++)
                System.out.print(matrix[i][right] + " ");
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--)
                    System.out.print(matrix[bottom][i] + " ");
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    System.out.print(matrix[i][left] + " ");
                left++;
            }
        }

        System.out.println();
    }

    public static int[][] copyMatrix(int[][] matrix) {
        int[][] copy = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(matrix[i], 0, copy[i], 0, matrix[0].length);
        }

        return copy;
    }

    public static void main(String[] args) {

        int[][] matrix = inputMatrix();

        while (true) {

            System.out.println("\n========== MENU ==========");
            System.out.println("1-a. Sort the matrix row-wise");
            System.out.println("1-b. Sort the matrix column-wise");
            System.out.println("2-a. Rotate Matrix Clockwise by 1");
            System.out.println("2-b. Rotate Matrix Counter-Clockwise by 1");
            System.out.println("2-c. Rotate a matrix by 90");
            System.out.println("2-d. Rotate a matrix by 180");
            System.out.println("3-a. Row-wise traversal of matrix");
            System.out.println("3-b. Column-wise traversal of matrix");
            System.out.println("4. Print matrix in spiral form");
            System.out.println("5. Transpose matrix");
            System.out.println("6. Quit");

            System.out.print("\nPilih menu: ");
            String choice = input.next().toLowerCase();

            switch (choice) {

                case "1-a":
                    matrix = sortRowWise(matrix);
                    printMatrix(matrix);
                    break;

                case "1-b":
                    matrix = sortColumnWise(matrix);
                    printMatrix(matrix);
                    break;

                case "2-a":
                    matrix = rotateClockwiseByOne(matrix);
                    printMatrix(matrix);
                    break;

                case "2-b":
                    matrix = rotateCounterClockwiseByOne(matrix);
                    printMatrix(matrix);
                    break;

                case "2-c":
                    matrix = rotate90(matrix);
                    printMatrix(matrix);
                    break;

                case "2-d":
                    matrix = rotate180(matrix);
                    printMatrix(matrix);
                    break;

                case "3-a":
                    rowWiseTraversal(matrix);
                    break;

                case "3-b":
                    columnWiseTraversal(matrix);
                    break;

                case "4":
                    spiralPrint(matrix);
                    break;

                case "5":
                    matrix = transpose(matrix);
                    printMatrix(matrix);
                    break;

                case "6":
                    System.out.println("Program selesai.");
                    return;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
}