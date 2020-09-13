// Union Find
// My solution
// O(nlogn), O(n)

class Solution {
    public class UnionFind {
        public int size;
        public int numComponents;
        public int[] id;
        public int[] sz;
        public UnionFind(int size) {
            if (size <= 0) {
                throw new IllegalArgumentException("Size <= 0 is not allowed!");
            }
            numComponents = size;
            id = new int[size];
            sz = new int[size];
            for (int i = 0; i < size; i++) {
                id[i] = i;
                sz[i] = 1;
            }
        }
        public int find(int p) {
            int root = p;
            while (root != id[root]) {
                root = id[root];
            }
            while (p != root) {
                int next = id[p];
                id[p] = root;
                p = next;
            }
            return root;
        }
        
        public int components() {
            return numComponents;
        }
        
        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }
        public void union(int p, int q) {
            int root1 = find[p]; //注意！如果你没有path compression，必须要使用find() function，如果你有path compression，可以用id[p]
            int root2 = find[q];
            if (root1 == root2) {
                return;
            }
            if (sz[root1] <= sz[root2]) {
                sz[root2] += sz[root1];
                id[root1] = root2;
            } else {
                sz[root1] += sz[root2];
                id[root2] = root1;
            }
            numComponents--;
        }
        
    }
    public int earliestAcq(int[][] logs, int N) {
        int time = 0;
        UnionFind uf = new UnionFind(N);
        Arrays.sort(logs, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < logs.length; i++) {
            if (uf.components() == 1) {
                return time;
            }
            if (uf.connected(logs[i][1], logs[i][2]))
            {
                continue;
            } else {
                uf.union(logs[i][1], logs[i][2]);
                time = logs[i][0];
            }
        }
        if (uf.components() == 1)
        {
            return time;
        }
        return -1;
    }
}

// Discussion 1
// O(nlogn), O(n)
class Solution {
    public class UF{
        int[] parent; //简化了int[] sz, int size, components()等等不必要的
        int res;
        UF(int size){
            parent = new int[size];
            for(int i = 0; i < size; i++)
                parent[i] = i;
            res = size;
        }
        public int find(int child){
            if(parent[child] != child){
                int p = find(parent[child]); //find parent recursively，这里用了recursive，我用的是iterative
                parent[child] = p;//update child's parent，这里其实也是path compression
            }
                
            return parent[child];
        }
        public void union(int a, int b){
            int pa = find(a);
            int pb = find(b);
            if(pa != pb){
                parent[pb] = pa;
                res--;//when union happens, we decrement one parent，这里没有用rank的概念，没用int[] sz
            }
             
        }
    }
    public int earliestAcq(int[][] logs, int N) {
        Arrays.sort(logs, (a, b) -> (a[0] - b[0]));
        UF uf = new UF(N);
        for(int[]log : logs){
            uf.union(log[1], log[2]); //这里采用先merge再判断的方法，比我的解少了好多判断语句
            if(uf.res == 1)
                return log[0];
        }
        return -1;
    } 
}

// Discussion 2
// O(nlogn), O(n)
def earliestAcq(self, logs, N):
    uf = {x: x for x in xrange(N)}
    self.groups = N

    def merge(x, y):
        x, y = find(x), find(y)
        if x != y:
            self.groups -= 1
            uf[x] = y

    def find(x):
        if uf[x] != x:
            uf[x] = find(uf[x])
        return uf[x]

    for t, x, y in sorted(logs):
        merge(x, y)
        if self.groups == 1:
            return t
    return -1
