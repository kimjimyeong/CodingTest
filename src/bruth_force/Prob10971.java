package bruth_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob10971 {

    static int N;
    static int Min = Integer.MAX_VALUE;
    static int[][] cost;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        cost = new int[N][N];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N];
        visited[0] = true;
        dfs(0, 0, 1, 0);


        System.out.println(Min);
    }

    private static void dfs(int start, int now, int cnt, int sum) {
        if(cnt == N){
            if(cost[now][start] != 0) Min = Math.min(Min, sum + cost[now][start]);
            return;
        }

        for(int i = 0; i < N; i++){
            if(!visited[i] && cost[now][i] != 0){
                visited[i] = true;
                dfs(start, i, cnt+1, sum + cost[now][i]);
                visited[i] = false;
            }
        }
    }

}
