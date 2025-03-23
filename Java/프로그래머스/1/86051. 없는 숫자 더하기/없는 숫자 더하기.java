import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        Arrays.sort(numbers);
        
        Integer[] all = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] numbersI = Arrays.stream(numbers).boxed().toArray(Integer[]::new);

        Set<Integer> allH = new HashSet<>(Arrays.asList(all));
        Set<Integer> numbersH = new HashSet<>(Arrays.asList(numbersI));
        
        allH.removeAll(numbersH);
        
        for (Integer i : allH) {
            answer += Integer.valueOf(i);
        }
        
        return answer;
    }
}