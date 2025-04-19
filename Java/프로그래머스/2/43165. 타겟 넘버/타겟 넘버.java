import java.util.*;

class Solution {
    
    int[] arr;
    int count, goal;
    
    void dfs(int idx, int result) {
        if (idx == arr.length) {
            if (result == goal) count++;
            return;
        }
        
        dfs(idx+1, result+arr[idx]);
        dfs(idx+1, result-arr[idx]);
    }
    
    public int solution(int[] numbers, int target) {
        arr = numbers;
        goal = target;
        
        dfs(0, 0);

        return count;
    }
}