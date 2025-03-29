import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int n = nums.length;
        Set<Integer> pms = new HashSet<>();
        
        for (int i : nums) pms.add(i);
        
        if (pms.size() >= n/2) answer = n/2;
        else answer = pms.size();

        return answer;
    }
}