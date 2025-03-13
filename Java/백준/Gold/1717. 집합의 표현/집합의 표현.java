import java.util.*;
import java.io.*;

// n + 1 개의 집합으로 구성됨 (0 ~ n)
// m 개의 연산에서
// 0으로 시작: 합집합 연산 - 대표 노드 찾아 연결 (union + find)
// 1로 시작: 같은 집합인지 확인

public class Main {

    static int[] arr;

    private static void execUnion(int a, int b) {
        // 대표 노드 찾아 연결
        a = verifyFind(a);
        b = verifyFind(b);
        if (a != b) {
            arr[b] = a; // 두 노드 연결
        }
    }

    private static int verifyFind(int a) {
        if (a == arr[a]) return a;  // 대표 노드일 경우
        else {
            return arr[a] = verifyFind(arr[a]);
            // value를 index로 바꿔서 찾아보기 (여기까지만 하면 시간 초과)
            // 재귀함수 빠져나올 때마다 그 때의 대표 노드로 업데이트
        }
    }

    private static boolean checkSame(int a, int b) {
        a = verifyFind(a);
        b = verifyFind(b);
        if (a == b) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n+1];

        for (int i=0; i<=n; i++) {
            arr[i] = i;
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int uf = Integer.parseInt(st.nextToken());
            int tmp_a = Integer.parseInt(st.nextToken());
            int tmp_b = Integer.parseInt(st.nextToken());

            int a = Math.min(tmp_a, tmp_b);
            int b = Math.max(tmp_a, tmp_b);

            if (uf == 1) {
                boolean result = checkSame(a, b);
                if (result) {
                    System.out.println("YES");
                } else System.out.println("NO");
            } else {
                execUnion(a, b);
            }
        }
    }

}
