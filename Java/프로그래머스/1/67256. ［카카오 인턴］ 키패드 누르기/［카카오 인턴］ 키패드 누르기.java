import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        char cur_l = '*', cur_r = '#';        // 현재 왼/오 엄지손가락 위치 알고 있어야
        Map<Character, int[]> posMap = new HashMap<>();  // 문자 -> 문자의 (x, y)
        Set<Integer> lSet = new HashSet<>(Arrays.asList(1, 4, 7));
        Set<Integer> rSet = new HashSet<>(Arrays.asList(3, 6, 9));
        
        char[][] keypad = {
            {'1', '2', '3'},
            {'4', '5', '6'},
            {'7', '8', '9'},
            {'*', '0', '#'}
        };
        
        for (int i=0; i<keypad.length; i++) {
            for (int j=0; j<keypad[i].length; j++) {
                posMap.put(keypad[i][j], new int[]{i, j});
            }
        }
            
        for (int n : numbers) {
            if (lSet.contains(n)) {
                answer += "L";
                cur_l = Character.forDigit(n, 10);
            } else if (rSet.contains(n)) {
                answer += "R";
                cur_r = Character.forDigit(n, 10);
            } else { // n과 cur_l & cur_r과의 차이 각각 구해서 더 가까운 쪽으로, 같으면 hand에 따라
                int[] nPos = posMap.get(Character.forDigit(n, 10));
                int[] lPos = posMap.get(cur_l);
                int[] rPos = posMap.get(cur_r);
                int l = Math.abs(nPos[0] - lPos[0]) + Math.abs(nPos[1] - lPos[1]);
                int r = Math.abs(nPos[0] - rPos[0]) + Math.abs(nPos[1] - rPos[1]);
                
                if ((l < r) || (r == l && "left".equals(hand))) {
                    answer += "L";
                    cur_l = Character.forDigit(n, 10);
                } else if ((r < l) || (r == l && "right".equals(hand))) {
                    answer += "R";
                    cur_r = Character.forDigit(n, 10);
                } 
            }
        }
        
        return answer;
    }
}

