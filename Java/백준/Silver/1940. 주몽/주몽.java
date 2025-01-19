import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0, start_index = 0, end_index = 1;
        int sum = 0;
        while(start_index != N-1) {
            sum = nums[start_index] + nums[end_index];
            if(sum == M) {
                count++;
                start_index++;
                end_index = start_index + 1;
            } else if(end_index < N-1){
                end_index++;
            } else {
                start_index++;
                end_index = start_index + 1;
            }
        }
        System.out.println(count);
    }
}