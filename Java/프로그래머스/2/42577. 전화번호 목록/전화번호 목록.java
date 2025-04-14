import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Set<String> phone_set = new HashSet<>();
        
        for (String p : phone_book) {
            phone_set.add(p);
        }
        
        for (String p : phone_book) {
            for (int i=1; i<p.length(); i++) {
                if (phone_set.contains(p.substring(0, i))) {
                    answer = false;
                    break;
                }
            }
        }
        
        return answer;
    }
}