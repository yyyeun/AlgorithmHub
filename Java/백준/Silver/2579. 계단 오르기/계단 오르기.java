// 최대 두 칸까지 이동 가능
// 연속 세 칸 이동 불가
// 마지막은 반드시 밟기
// -> 최댓값

import java.io.*;
import java.util.*;

public class Main {

    static Integer dp[];
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new Integer[N+1];
        arr = new int[N+1];

        for (int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = arr[0];
        dp[1] = arr[1];

        if (N >= 2) {
            dp[2] = arr[1] + arr[2];
        }

        System.out.println(find(N));
    }

    static int find(int N) {
        if (dp[N] == null) {
            dp[N] = Math.max(find(N-2), find(N-3)+arr[N-1]) + arr[N];
        }

        return dp[N];
    }
}
