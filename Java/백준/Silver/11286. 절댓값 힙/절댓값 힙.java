import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();

            if (num != 0) {
                // 배열에 값을 추가
                if (num > 0) pq1.add(num);
                else pq2.add(num);
            } else {
                // 배열이 비어 있는 경우는 0 출력
                if (pq1.isEmpty() && pq2.isEmpty()) System.out.println(0);
                // 배열에서 절댓값이 가장 작은 값을 출력하고 그 값을 배열에서 제거
                else {
                    if (!pq1.isEmpty() && (pq2.isEmpty() || pq1.peek() < pq2.peek() * -1)) System.out.println(pq1.poll());
                    else if (!pq2.isEmpty() && (pq1.isEmpty() || pq1.peek() >= pq2.peek() * -1)) System.out.println(pq2.poll());
                }
            }
        }
    }
}
