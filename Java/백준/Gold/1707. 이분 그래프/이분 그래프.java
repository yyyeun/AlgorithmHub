import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static char[] nodeSet;
    static boolean isBipartiteGraph;

    private static void dfs(int node) {
        if (visited[node]) return;
        visited[node] = true;

        for (int nodes : graph[node]) {
            if (!visited[nodes]) {
                nodeSet[nodes] = (nodeSet[node] == 'A') ? 'B' : 'A';
                dfs(nodes);
            } else {
                if (nodeSet[nodes] == nodeSet[node]) {
                    isBipartiteGraph = false;
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        for (int k=0; k<K; k++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            graph = new ArrayList[V+1];
            visited = new boolean[V+1];
            nodeSet = new char[V+1];
            isBipartiteGraph = true;

            for (int v=1; v<=V; v++) {
                graph[v] = new ArrayList<>();
            }

            for (int e=0; e<E; e++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph[a].add(b);
                graph[b].add(a);
            }

            for (int i=1; i<=V; i++) {
                if (!visited[i]) {
                    nodeSet[i] = 'A';
                    dfs(i);
                }
            }

            if (isBipartiteGraph) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
