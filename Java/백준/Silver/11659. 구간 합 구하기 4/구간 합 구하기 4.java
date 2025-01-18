import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int A[] = new int[N+1];
        int S[] = new int[N+1];

        A[0] = 0;
        S[0] = 0;
        for(int i = 1; i <= N; i++) {
            A[i] = sc.nextInt();
            if (i >= 2) {
                S[i] = S[i-1] + A[i];
            }
            else S[i] = A[i];
        }

        for(int i = 0; i < M; i++) {
            int I = sc.nextInt();
            int J = sc.nextInt();

            System.out.println(S[J] - S[I-1]);
        }

    }
}
