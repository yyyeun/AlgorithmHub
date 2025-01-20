import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        char[] dna = br.readLine().toCharArray();
        int[] min = new int[4]; // {‘A’, ‘C’, ‘G’, ‘T’} 의 최소 개수
        int[] cur = new int[4];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
           min[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < P; i++) {
            if(dna[i] == 'A') cur[0]++;
            else if(dna[i] == 'C') cur[1]++;
            else if(dna[i] == 'G') cur[2]++;
            else if(dna[i] == 'T') cur[3]++;
        }

        int count = 0;
        for(int i = 0; i < S-P+1; i++) {
            if(cur[0] >= min[0] && cur[1] >= min[1] && cur[2] >= min[2] && cur[3] >= min[3]) {
                count++;
            }

            if(dna[i] == 'A') cur[0]--;
            else if(dna[i] == 'C') cur[1]--;
            else if(dna[i] == 'G') cur[2]--;
            else if(dna[i] == 'T') cur[3]--;

            if(i+P < S && dna[i+P] == 'A') cur[0]++;
            else if(i+P < S && dna[i+P] == 'C') cur[1]++;
            else if(i+P < S && dna[i+P] == 'G') cur[2]++;
            else if(i+P < S && dna[i+P] == 'T') cur[3]++;
        }
        System.out.println(count);
    }
}
