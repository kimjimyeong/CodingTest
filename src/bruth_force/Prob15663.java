package bruth_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob15663 {

    static int N, M;
    static int[] nums;
    static int[] output;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        visited = new boolean[N];
        output = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int cnt) {
        if(cnt == M){
            for(int each : output){
                sb.append(each).append(" ");
            }
            sb.append("\n");
        }
        else{
            int before = 0;
            for(int i = 0; i < N; i++){
                if(before != nums[i] && !visited[i]){
                    before = nums[i];
                    output[cnt] = nums[i];
                    visited[i] = true;
                    dfs(cnt+1);
                    visited[i] = false;
                }
            }
        }
    }
}
