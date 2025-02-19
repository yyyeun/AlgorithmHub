import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
    	HashSet<String> S = new HashSet<>();
        for(int i=0; i<str.length(); i++) {
    		for(int j=i+1; j<=str.length(); j++) {
    			String temp = str.substring(i, j);
    			if(!S.contains(temp))
    				S.add(temp);	
    		}
    	}
    	System.out.println(S.size());
    }
}
 