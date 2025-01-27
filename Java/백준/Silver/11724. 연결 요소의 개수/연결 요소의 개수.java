import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // 그래프
    private static boolean[] visited;
    private static int count = 0;
    private static PriorityQueue<Integer> sq = new PriorityQueue<>();

    private static void putEdge(int x, int y) {
        graph.get(x).add(y);
        graph.get(y).add(x);
    }

    private static void dfs(int start) {
        if (visited[start]) return;

        visited[start] = true;
        sq.remove(start);

        for (int nodes : graph.get(start)) {
            if (!visited[nodes]) {
                dfs(nodes);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 1. 인접 리스트로 그래프 생성
        // 2. DFS로 탐색하며 스택에 아무것도 안 남았을 때 count++;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 노드
        int M = Integer.parseInt(st.nextToken()); // 간선

        visited = new boolean[N+1];

        // 그래프 초기화
        for (int i = 0; i <= N; i++) { // 인덱스를 0부터가 아닌 1부터 사용하기 위해 +1
            graph.add(new ArrayList<>());
            if (i != 0) sq.add(i);
        }

        // 그래프 구성
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            putEdge(u, v);
        }

        // 탐색
        while (sq.size() > 0) {
            dfs(sq.poll());
            count++;
        }
        System.out.println(count);
    }
}
