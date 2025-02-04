import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static void searchNum(int[] A, int target) {
        boolean isFound = false;
        int start = 0;
        int end = A.length - 1;
        int midi;

        while (start <= end) {
            midi = (start + end) / 2; 

            if (target > A[midi]) {
                start = midi + 1;
            } else if (target < A[midi]) {
                end = midi - 1;
            } else {
                isFound = true;
                break;
            }
        }

        if (isFound) System.out.println(1);
        else System.out.println(0);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int iNum = Integer.parseInt(st.nextToken());
            searchNum(A, iNum);
        }
    }
}
