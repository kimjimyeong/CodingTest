package bruth_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob14889 {

    static int N;
    static int[][] S;
    static boolean[] visited;
    static int Min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; st.hasMoreTokens(); j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(Min);
    }

    public static void dfs(int idx, int depth) {
        if(depth == N/2){
            calculateDiff();
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i+1, depth + 1);
                visited[i] = false;
            }
        }
    }

    private static void calculateDiff() {
        int start = 0;
        int link = 0;

        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    start += S[i][j];
                    start += S[j][i];
                }
                else if (!visited[i] && !visited[j]){
                    link += S[i][j];
                    link += S[j][i];
                }
            }
        }

        int diff = Math.abs(start - link);

        if (diff == 0) {
            System.out.println(0);
            System.exit(0);
        }

        Min = Math.min(Min, diff);
    }
}
