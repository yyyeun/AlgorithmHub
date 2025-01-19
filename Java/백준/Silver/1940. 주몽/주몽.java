import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 1) N의 최대 범위가 15,000이므로 오름차순 정렬하기 (일반적으로 시간 복잡도가 O(NlogN)임) **
        Arrays.sort(nums);

        // 2) 투 포인터를 양 끝에 위치시키기
        int count = 0, i = 0, j = N-1;

        // 3) 이동 원칙 세우기
        //    다음을 start_index와 end_index가 만날 때까지 수행
        //    - 합이 M보다 작으면 start_index++
        //    - 합이 M보다 크면 end_index--
        //    - 합이 M이면 count++, start_index++, end_index--
        while(i < j) {
            if(nums[i] + nums[j] < M) i++;
            else if(nums[i] + nums[j] > M) j--;
            else {
                count++;
                i++; j--;
            }
        }

        // 기존 풀이: 정렬 X (Time: 304 ms, Memory: 17848 KB)
        /*
        int count = 0, sum = 0, start_index = 0, end_index = 1;
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
         */

        System.out.println(count);
    }
}