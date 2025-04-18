import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int length = answers.length;
        int cor1 = 0, cor2 = 0, cor3 = 0;
        List<Integer> list = new ArrayList<>();
        
        int[] stu1 = {1, 2, 3, 4, 5}; // 5
        int[] stu2 = {2, 1, 2, 3, 2, 4, 2, 5}; // 8
        int[] stu3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 10
        
        for (int i=0; i<answers.length; i++) {
            if (answers[i] == stu1[i%5]) cor1++;
            if (answers[i] == stu2[i%8]) cor2++;
            if (answers[i] == stu3[i%10]) cor3++;
        }
        
        int max = Math.max(cor1, Math.max(cor2, cor3));
        
        if (max == cor1) list.add(1);
        if (max == cor2) list.add(2);
        if (max == cor3) list.add(3);
        
        int[] answer = list.stream()
                            .mapToInt(Integer::intValue)
                            .toArray();
        
        return answer;
    }
}