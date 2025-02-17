import java.io.*;
import java.util.*;

public class Main {
    private static long GCD(long a, long b) {
        return (b == 0) ? a : GCD(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        // 두 수가 같으면 정답은 1이 된다.
        if (A == B) {
            System.out.println(1);
            return;
        }

        // A < B가 되도록 정렬
        if (A > B) {
            long temp = A;
            A = B;
            B = temp;
        }

        long D = B - A; // B - A의 값

        // (B - A)의 약수 구하기 (O(√D))
        TreeSet<Long> divisors = new TreeSet<>();
        for (long i = 1, lim = (long) Math.sqrt(D); i <= lim; i++) {
            if (D % i == 0) {
                divisors.add(i);
                divisors.add(D / i);
            }
        }

        long minN = -1;
        long minLCM = Long.MAX_VALUE;

        // 각 약수를 탐색하여 최소 N 찾기
        for (long d : divisors) {
            long r = A % d;
            long N = d - r;
            long lcm = ((A + N) * (B + N)) / d; // 최소공배수 계산

            if (lcm < minLCM || (lcm == minLCM && N < minN)) {
                minLCM = lcm;
                minN = N;
            }
        }

        System.out.println(minN);
    }
}
