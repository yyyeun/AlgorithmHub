import java.util.*;

// 중복 없는 조합 -> HashSet
class Solution {
    HashSet<String> set;
    String[] regex;
    String[] user_id_all;
    boolean[] visited;
    
    public int solution(String[] user_id, String[] banned_id) {
        set = new HashSet<>();
        user_id_all = user_id;
        visited = new boolean[user_id_all.length];
        
        regex = new String[banned_id.length];
        for (int i=0; i<banned_id.length; i++) {
            regex[i] = banned_id[i].replace("*", ".");
        }
        
        bt(0, "");
        
        return set.size();
    }
    
    void bt(int idx, String result) {
        if (idx == regex.length) {  // 종료 조건
            String[] str = result.split(" ");
            Arrays.sort(str);
            
            String resultF = "";
            for (int i=0; i<str.length; i++) resultF += str[i];
            
            set.add(resultF);
            return;
        }
        
        for (int i=0; i<user_id_all.length; i++) {
            // user 차례대로 순회하며 result 문자열에 방문한 적 없으면서 정규표현식에 맞는 id 추가
            if (visited[i] == false && user_id_all[i].matches(regex[idx])) {
                visited[i] = true;
                bt(idx+1, result+" "+user_id_all[i]);
                visited[i] = false;
            }
        }
        
    }
}