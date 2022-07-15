package CP.GRAPH;

//https://codeforces.com/problemset/problem/1702/E

import java.util.*;

public class Bipartite {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            solve(sc);
        }

    }

    public static void solve(Scanner sc)
    {
        int n=sc.nextInt();
        int[] ct=new int[n+1];
        ArrayList<ArrayList<Integer>> lst=new ArrayList<>();

        for (int i=0;i<n+1;i++) {
            lst.add(new ArrayList<Integer>());
        }
        boolean isPoss=true;
        for (int i=0;i<n;i++) {
            int u=sc.nextInt();
            int v=sc.nextInt();
            ct[u]++;
            ct[v]++;
            if (ct[u]>=3 || ct[v]>=3) {
                isPoss=false;
            }
            lst.get(u).add(v);
            lst.get(v).add(u);
        }
        if (!isPoss) {
            System.out.println("NO");
            return;
        }
        if (isBipartite(n+1,lst)) {
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

    }

    public static boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        Queue<Integer> q = new LinkedList<>();
        int[] colour = new int[V];
        boolean[] vis = new boolean[V];
        boolean res = true;

        for(int k=0;k<V;k++){
            if(vis[k]==false){
                q.add(k);
                colour[k]=1;
                vis[k]=true;

                while(!q.isEmpty()){
                    int node = q.poll();
                    vis[node]=true;
                    if(colour[node]==0 || colour[node]==1){
                        colour[node]=1;
                        for(long i:adj.get(node)){
                            if(colour[(int) i]==1){
                                res = false;
                                q.clear();
                                break;
                            }else{
                                if(!vis[(int) i]){
                                    q.add((int) i);
                                }
                                colour[(int) i]=2;
                            }
                        }
                    }else{
                        for(long i:adj.get(node)){
                            if(colour[(int) i]==2){
                                res = false;
                                q.clear();
                                break;
                            }else{
                                if(!vis[(int) i]){
                                    q.add((int) i);
                                }
                                colour[(int) i]=1;
                            }
                        }
                    }
                }
            }
            if(!res){
                break;
            }
        }
        return res;
    }

    public static boolean isBipartite1(int V, ArrayList<ArrayList<Integer>> adj)
    {

        // vector to store colour of vertex
        // assigning all to -1 i.e. uncoloured
        // colours are either 0 or 1
        // for understanding take 0 as red and 1 as blue
        int col[] = new int[V];
        Arrays.fill(col, -1);

        // queue for BFS storing {vertex , colour}
        Queue<Pair> q = new LinkedList<Pair>();

        //loop incase graph is not connected
        for (int i = 0; i < V; i++) {

            // if not coloured
            if (col[i] == -1) {

                // colouring with 0 i.e. red
                q.add(new Pair(i, 0));
                col[i] = 0;

                while (!q.isEmpty()) {
                    Pair p = q.peek();
                    q.poll();

                    //current vertex
                    int v = p.first;

                    // colour of current vertex
                    int c = p.second;

                    // traversing vertexes connected to current vertex
                    for (int j : adj.get(v))
                    {

                        // if already coloured with parent vertex color
                        // then bipartite graph is not possible
                        if (col[j] == c)
                            return false;

                        // if uncoloured
                        if (col[j] == -1)
                        {

                            // colouring with opposite color to that of parent
                            col[j] = (c==1) ? 0 : 1;
                            q.add(new Pair(j, col[j]));
                        }
                    }
                }
            }
        }

        // if all vertexes are coloured such that
        // no two connected vertex have same colours
        return true;
    }

    static class Pair{
        int first, second;

        Pair(int f, int s){
            first = f;
            second = s;
        }
    }
}
