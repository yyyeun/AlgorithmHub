import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 공백으로 나눠진 정수 값들을 정수 배열로 입력 받기
        int iNum[] = new int[N];
        for(int i = 0; i < N; i++) {
            iNum[i] = sc.nextInt();
        }

        // max 값 선별 및 sum 누적
        long max = 0;
        long sum = 0;
        for(int i = 0; i < N; i++) {
            if(max < iNum[i]) max = iNum[i];
            sum += iNum[i];
        }

        System.out.println(sum * 100.0 / max / N); // 정수와 실수 타입이 섞여 있기 때문에 이 순서로 해야 값이 제대로 나옴
    }
}
