import java.io.*;
public class Main {
    
    static int[][] DP = new int[10001][4];
    
    static void init(){
        DP[1][1] = DP[2][1] = DP[2][2] = DP[3][1] = DP[3][2] = DP[3][3] = 1;
    }
    
    static void getDP(){
        for(int i=4;i<10001;i++){
            DP[i][1] = DP[i-1][1];
            DP[i][2] = DP[i-2][1] + DP[i-2][2];
            DP[i][3] = DP[i-3][1] + DP[i-3][2] + DP[i-3][3];
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        init();	
        getDP();	
        
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            int N = Integer.parseInt(br.readLine());
            int result = DP[N][1] + DP[N][2] + DP[N][3];
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}