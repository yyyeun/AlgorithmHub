import java.io.*;

public class Main {
    // DP 문제는 대부분 큰 문제를 작은 문제로 나눌 수 있는 규칙을 찾아 수식(점화식)을 세운다.
    // 메모라이제이션, 즉 미리 가져다 쓸 값들을 위 수식을 적용해 저장한다.
    // 결과값을 구할 때는 메모라이제이션 해둔 배열에서 값을 가져다 쓴다.

    static int[][] DP = new int[10001][4];  // 메모라이제이션 배열

    static void init(){   // 초기화
        DP[1][1] = DP[2][1] = DP[2][2] = DP[3][1] = DP[3][2] = DP[3][3] = 1;
    }

    static void getDP(){  // 점화식
        // i: 만들 값, j: 오름차순 상태의 수식에서 끝나는 값
        for (int i=4; i<10001; i++) {
            DP[i][1] = DP[i-1][1];                             // (이전 수식) + 1, 최대가 1이므로 앞 수식은 1로 끝남
            DP[i][2] = DP[i-2][1] + DP[i-2][2];                // (이전 수식) + 2, 최대가 2이므로 앞 수식은 1 또는 2로 끝날 수 있음 
            DP[i][3] = DP[i-3][1] + DP[i-3][2] + DP[i-3][3];   // (이전 수식) + 3, 최대가 3이므로 앞 수식은 1, 2 또는 3으로 끝날 수 있음
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        init();
        getDP();

        int T = Integer.parseInt(br.readLine());
        for (int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            int result = DP[N][1] + DP[N][2] + DP[N][3];  // 수식이 1/2/3으로 끝나는 경우(즉, 각 수식에서 최대가 1/2/3)를 모두 더한다
            System.out.println(result);
        }
    }

    // 참고 링크
    // https://velog.io/@jkh9615/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-15989-1-2-3-%EB%8D%94%ED%95%98%EA%B8%B0-4-Java
    // https://tussle.tistory.com/805
}