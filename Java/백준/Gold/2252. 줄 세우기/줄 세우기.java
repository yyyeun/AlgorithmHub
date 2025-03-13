import java.util.*;
import java.io.*;

// 학생들을 노드로, 키 순서 비교 데이터를 에지로 생각 -> 노드의 순서를 도출하는 문제 => 위상 정렬
// "답이 여러 가지일 경우에는 아무거나 출력한다" => 위상 정렬의 특징

// 그래프 및 진입 차수 배열 표현
// 조건: "A가 B의 앞에 서야 한다"
// 입력: 4 2 / 3 1
// 그래프: 4 -> 2 / 3 -> 1
// 진입 차수 배열: idx | 1 2 3 4
//              val | 1 1 0 0

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 인접 리스트 초기화
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for (int i=0; i<=N; i++) {
            A.add(new ArrayList<>());
        }

        // 진입 차수 배열 초기화
        int indegree[] = new int[N+1];

        // 인접 리스트, 진입 차수 배열 데이터 저장
        for (int i=0; i<M; i++) {
            int S = sc.nextInt();
            int E = sc.nextInt();
            A.get(S).add(E);  // 4 -> 2
            indegree[E]++;    // indegree[2]++
        }

        // --- 위상 정렬 수행 ---
        // 큐 생성
        Queue<Integer> queue = new LinkedList<>();

        // 진입 차수가 0인 노드를 큐에 offer
        for (int i=1; i<=N; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            int now = queue.poll();  // 큐에서 poll
            System.out.print(now + " ");

            for (int next : A.get(now)) {  // 현재 노드와 연결된 노드만큼
                indegree[next]--;          // 연결된 노드의 진입 차수를 1씩 감소
                if (indegree[next] == 0) {
                    queue.offer(next);     // 진입 차수가 0인 노드를 큐에 offer
                }
            }
        }
    }
}
