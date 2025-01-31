import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int M, N, K;
    static int[]  dx = {0, 0, 1, -1}; // 탐색 배열
    static int[]  dy = {1, -1, 0, 0}; // 오, 왼, 위, 아래
    static int[][] A;                 // 데이터 배열
    static boolean[][] visited;       // 방문 배열
    static int count, tmp = 1;            // 영역 개수
    static ArrayList<Integer> S = new ArrayList<>();      // 영역별 넓이 배열

    private static void DFS(int x, int y) {
        if (visited[x][y]) return;

        visited[x][y] = true;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (!visited[nx][ny] && A[nx][ny] != -1) {
                    tmp++;
                    DFS(nx, ny);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 세로 길이, <= 100
        N = Integer.parseInt(st.nextToken()); // 가로 길이, <= 100
        K = Integer.parseInt(st.nextToken()); // 직사각형 개수, <= 100
        A = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    A[x][y] = -1;
                    visited[x][y] = true;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    DFS(i, j);
                    count++;
                    S.add(tmp); tmp = 1;
                }
            }
        }

        System.out.println(count);
        Collections.sort(S);
        for (int s : S) System.out.print(s + " ");
    }
}
