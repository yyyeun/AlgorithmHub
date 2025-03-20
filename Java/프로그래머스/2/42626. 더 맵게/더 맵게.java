import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int s : scoville) {
            pq.add(s);
        }
        
        while (pq.size() > 1) {
            int min1 = pq.poll();
            
            if (min1 >= K) {
                break;
            }
            answer++;
            
            int min2 = pq.poll();
            int newS = min1 + min2 * 2;
            pq.add(newS);
        }
        if (pq.poll() < K) answer = -1;
        
        return answer;
    }
}