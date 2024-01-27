import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob3085 {
    public static char[][] board;
    public static int N;
    public static int max;

    public static void swap(int x1, int y1, int x2, int y2){
        char swap = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = swap;
    }

    private static void findMax() {
        for(int i = 0; i < N; i++){
            int rowCount = 1;

            for(int j = 0; j < N-1; j++){
                if (board[i][j] != board[i][j + 1]) {
                    max = Math.max(rowCount, max);
                    rowCount = 1;
                }else rowCount++;
            }
            max = Math.max(rowCount, max);
        }

        for(int i = 0; i < N; i++){
            int colCount = 1;

            for(int j = 0; j < N-1; j++){
                if (board[j][i] != board[j + 1][i]) {
                    max = Math.max(colCount, max);
                    colCount = 1;
                }else colCount++;
            }
            max = Math.max(colCount, max);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new char[N][N];

        for (int i = 0; i < N; i++){
            String str = br.readLine();
            board[i] = str.toCharArray();
        }

        for(int i = 0; i < N; i++){
            for (int j = 0; j < N-1; j++){
                swap(i , j, i, j+1);
                findMax();
                swap(i , j, i, j+1);
            }
        }

        for(int i = 0; i < N - 1; i++){
            for (int j = 0; j < N; j++){
                swap(i, j, i+1, j);
                findMax();
                swap(i, j, i+1, j);
            }
        }


        System.out.println(max);
        br.close();
    }


}
