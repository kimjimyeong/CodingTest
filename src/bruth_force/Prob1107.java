package bruth_force;

import java.io.*;
import java.util.StringTokenizer;


public class Prob1107 {

    public static int N, M;
    public static boolean[] brokenBtn = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        if(M > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++){
                int cur = Integer.parseInt(st.nextToken());
                brokenBtn[cur] = true;
            }
        }

        if(N == 100){
            System.out.println(0);
            return;
        }

        int cnt = Math.abs(N - 100);

        for (int i = 0; i <= 999999; i++) {
            String cur = String.valueOf(i);
            boolean check = false;

            for (int j = 0; j < cur.length(); j++) {
               if(brokenBtn[cur.charAt(j) - '0']){
                   check = true;
                   break;
               }
            }
            if(!check) cnt = Math.min(cnt, cur.length() + Math.abs(i - N));
        }

        System.out.println(cnt);
        br.close();
    }

}
