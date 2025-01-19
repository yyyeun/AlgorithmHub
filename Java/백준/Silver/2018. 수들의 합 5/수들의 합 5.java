import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int start_index = 1, end_index = 1, sum = 1, count = 1;

        while(end_index != N) {
            if(sum > N) {
                sum -= start_index;
                start_index++;
            } else if(sum < N) {
                end_index++;
                sum += end_index;
            } else {
                count++;
                end_index++;
                sum += end_index;
            }
        }  // O(2N) -> O(N)
        System.out.println(count);
    }
}
