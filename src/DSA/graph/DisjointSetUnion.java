package DSA.graph;

public class DisjointSetUnion {
    public static void main(String[] args) {

    }

    //This function make the parent array
    //Assign each node as a parent to itself
    static void make(int[] parent, int n){
        for(int i=0;i<n;i++) parent[i] = i;
    }

    //This function find the parent of component
    static int findParent(int[] parent, int x){
        if(parent[x] == x) return x;
        return findParent(parent, parent[x]);
    }
    /**
     * This find parent is optimized with Path Compression
     * Let if 1 is the root 1 ->2 ->3 ->4
     * Ultimately root of 2,3 and 4 is 1
     * Path compression reduces the height of tree
     */
    static int findParentPathCompression(int[] parent, int x){
        if(parent[x] == x) return x;
        return parent[x] = findParentPathCompression(parent, parent[x]);
    }

    //This function unites the 2 component from its root node
    static void union(int[] parent, int a, int b){
        int parentOf_a = findParent(parent,a);
        int parentOf_b = findParent(parent,b);
        parent[parentOf_a]=parentOf_b;
    }

    /**
     * Union of 2 trees will be efficient if tree with lesser of nodes will be
     * connected to tree with greater number of nodes
     * Due to this the depth of larger tree will not increase and become same
     */

    void unionBySize(int[] parent, int[] size, int a, int b) {
        int parentOf_a = findParentPathCompression(parent,a);
        int parentOf_b = findParentPathCompression(parent,b);
        if (a != b) {
            if (size[parentOf_a] < size[parentOf_b])
                swap(parentOf_a, parentOf_b);
            parent[parentOf_b] = parentOf_a;
            size[parentOf_a] += size[parentOf_a];
        }
    }

    /**
     * In union by rank
     * if rank is not same -> the rank will be max of both the rank.
     * if rank is same -> then we have to increase rank.
     */
    void unionByRank(int[] parent, int[] rank, int a, int b) {
        int parentOf_a = findParentPathCompression(parent,a);
        int parentOf_b = findParentPathCompression(parent,b);
        if (a != b) {
            if (rank[a] < rank[b])
                swap(a, b);
            parent[b] = a;
            if (rank[a] == rank[b])
                rank[a]++;
        }
    }

    static void swap(int a, int b){
        int temp = a;
        a = b;
        b = temp;
    }


}
