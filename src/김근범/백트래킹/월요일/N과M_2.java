package 김근범.백트래킹.월요일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M_2 {
    static int N, M;
    static boolean[] check;
    static int[] sequence;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        check = new boolean[N+1];
        sequence = new int[M];
        sequence[sequence.length-1] = '\n';
        fetchSequences(0);
        System.out.print(sb);
    }

    private static void fetchSequences(int index) {
        if(index == M) {
            for(int i=0;i<sequence.length;i++){
                sb.append(sequence[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1;i<=N;i++){
            if(index == 0 || (sequence[index-1] < i && !check[i])) {
                check[i] = true;
                sequence[index] = i;
                fetchSequences(index+1);
                check[i] = false;
            }
        }
    }
}
