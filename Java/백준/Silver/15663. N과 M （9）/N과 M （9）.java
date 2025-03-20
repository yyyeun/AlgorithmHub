import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] nums;         // N개의 수 담을 우선순위 큐
    static int[] print;        // 결과 수열 출력할 배열
    static boolean[] visited;  // 방문 처리 배열

    private static void backtracking(int depth) {
        // (1) 수열의 길이가 M이 되면 출력 (종료 조건)
        if (depth == M) {
            for (int num : print) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        int prevDepthNum = -1;

        // (2) N개의 수를 차례대로 확인
        for (int i=0; i<nums.length; i++) {
            if (!visited[i] && prevDepthNum != nums[i]) { // prevDepthNum != nums[i] -> 중복 처리
                visited[i] = true;
                print[depth] = nums[i];
                prevDepthNum = nums[i];

                backtracking(depth+1);

                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());  // 1 <= N <= 8
        M = Integer.parseInt(st.nextToken());  // 1 <= M <= N
        nums = new int[N];
        print = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        // 수열 출력 - 사전 순, 중복 X (중복 처리 필요!!)
        backtracking(0);
    }

}
