package bruth_force;

import java.io.*;

public class Prob6064 {

    public static int T;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++){
            String[] temp = br.readLine().split(" ");
            int N = Integer.parseInt(temp[0]);
            int M = Integer.parseInt(temp[1]);
            int x = Integer.parseInt(temp[2]);
            int y = Integer.parseInt(temp[3]);


            int lastYear = M * N / gcd(M, N);
            boolean flag = false;

            for(int year = x; year <= lastYear; year += N){
                if((year - y) % M == 0){
                    bw.write(year + "\n");
                    flag = true;
                    break;
                }
            }

            if(!flag) bw.write(-1 + "\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }

    public static int gcd(int x, int y){
        if(x % y == 0){
            return y;
        }
        return gcd(y, x % y);
    }
}
