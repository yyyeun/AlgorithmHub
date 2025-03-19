import java.io.*;
import java.util.*;

// 가중치 있는 그래프 -> ArrayList<Node>[N]
class Node implements Comparable<Node> {
    int end, weight;

    public Node(int end, int weight) {
        this.end = end;       // 현재 노드에서 갈 수 있는 도착 노드 번호
        this.weight = weight; // 현재 노드에서 end 노드로 가는 가중치(비용)
    }

    @Override
    public int compareTo(Node o) { // 우선순위 큐에서 정렬 기준을 정의하는 메서드
        return weight - o.weight;  // 다익스트라 -> 최소 비용을 기준으로 노드를 선택해야 함 => weight가 작은 노드가 우선순위 큐에서 먼저 나올 수 있도록 정의함
        // 반환값이 0 -> 두 객체는 같은 우선순위
        // 반환값이 음수 -> 현재 객체(this)가 우선순위 더 높음
        // 반환값이 양수 -> 비교 대상 객체(o)가 우선순위 더 높음
    }
}

public class Main {
    static ArrayList<Node>[] graph; // 그래프
    static int[] dist;              // 최단 거리 배열
    static final int INF = Integer.MAX_VALUE;
    static int V, E, K;  // 노드 개수, 에지 개수, 시작 노드

    // 우선순위 큐에서 값이 가장 작은 노드 꺼내 최단 거리 배열 업데이트
    private static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>(); // 우선순위 큐
        boolean[] visited = new boolean[V+1];   // 방문 처리 배열

        // 시작 노드 값을 0으로 초기화
        queue.add(new Node(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {     // 큐가 빌 때까지 다음을 수행
            Node curNode = queue.poll(); // 큐에서 가장 작은 노드 꺼냄
            int cur = curNode.end;       // 도착 노드 확인 -> 현재 선택된 노드

            if (visited[cur]) continue;  // 선택 노드가 방문된 적 있으면 넘어감
            visited[cur] = true;         // 아니면 방문 처리

            for (Node n : graph[cur]) {  // 선택 노드의 연결 노드 확인
                if (dist[n.end] > dist[cur] + n.weight) {  // 연결 노드의 최단 거리 배열 값보다 선택 노드의 최단 거리 배열 값 + 에지 가중치 값이 더 작다면 업데이트
                    dist[n.end] = dist[cur] + n.weight;
                    queue.add(new Node(n.end, dist[n.end]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken()); // 노드 개수
        E = Integer.parseInt(st.nextToken()); // 에지 개수
        K = Integer.parseInt(br.readLine());  // 시작 노드

        graph = new ArrayList[V+1];
        dist = new int[V+1];

        Arrays.fill(dist, INF); // 최단 거리 배열을 INF 값으로 채움 

        for (int i=1; i<=V; i++) {
            graph[i] = new ArrayList<>(); // 그래프 초기화
        }

        for (int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // 출발 노드
            int v = Integer.parseInt(st.nextToken()); // 도착 노드
            int w = Integer.parseInt(st.nextToken()); // 가중치

            graph[u].add(new Node(v, w)); // 그래프 구현
        }

        dijkstra(K);

        // 완성된 최단 거리 배열 출력 (시작점은 0으로, 경로가 존재하지 않는 경우에는 INF를 출력)
        for (int i=1; i<=V; i++) {
            if (dist[i] == INF) System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }
}
