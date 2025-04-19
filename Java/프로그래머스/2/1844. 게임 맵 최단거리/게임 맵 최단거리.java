import java.util.*;

class Solution {
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        int[][] dist = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        dist[0][0] = 1;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            
            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (maps[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        dist[nx][ny] = dist[x][y] + 1;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        return dist[n-1][m-1] == 0 ? -1 : dist[n-1][m-1];
    }
    
}