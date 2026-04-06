import java.util.Scanner;

public class RotateImage {

        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                // 1. Read n and n (dimensions)
                if (!scanner.hasNextInt())
                        return;
                int n = scanner.nextInt();
                int n2 = scanner.nextInt(); // Consuming the second n

                int[][] matrix = new int[n][n];

                // 2. Read the matrix elements
                for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                                matrix[i][j] = scanner.nextInt();
                        }
                }

                // 3. Rotate the matrix 90 degrees clockwise INPLACE
                // Step A: Transpose the matrix
                for (int i = 0; i < n; i++) {
                        for (int j = i + 1; j < n; j++) {
                                int temp = matrix[i][j];
                                matrix[i][j] = matrix[j][i];
                                matrix[j][i] = temp;
                        }
                }

                // Step B: Reverse each row
                for (int i = 0; i < n; i++) {
                        int left = 0;
                        int right = n - 1;
                        while (left < right) {
                                int temp = matrix[i][left];
                                matrix[i][left] = matrix[i][right];
                                matrix[i][right] = temp;
                                left++;
                                right--;
                        }
                }

                // 4. Print the rotated matrix
                for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                                System.out.print(matrix[i][j] + (j == n - 1 ? "" : " "));
                        }
                        System.out.println();
                }

                scanner.close();
        }
}