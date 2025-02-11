import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<String, Integer> inOrder = new HashMap<>();
        int count = 0;

        // 차량이 터널에 들어간 순서 저장
        for (int i = 0; i < n; i++) {
            inOrder.put(sc.next(), i);
        }

        List<Integer> outOrder = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            outOrder.add(inOrder.get(sc.next()));
        }

        // 터널을 빠져나오는 과정에서 추월이 발생했는지 확인
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (outOrder.get(i) > outOrder.get(j)) {
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
