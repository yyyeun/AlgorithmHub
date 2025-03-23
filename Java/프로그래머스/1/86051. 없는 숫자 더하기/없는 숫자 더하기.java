import java.util.*;

class Solution {
    
    static int i;
    
    public int solution(int[] numbers) {
        int answer = 0;
        
        for (i=0; i<=9; i++) {
            if(!Arrays.stream(numbers).anyMatch(n -> n == i)) {
                answer += i;
            }
        }
        
        return answer;
    }
}