// Depth First Search, Union Find
// Approach 1: Depth First Search
// Time Complexity: O(∑ailogai), where ai is the length of accounts[i].
// Without the log factor, this is the complexity to build the graph and search for each component. The log factor is for sorting each component at the end.
// Space Complexity: O(∑ai), the space used by our graph and our search.
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap();
        Map<String, ArrayList<String>> graph = new HashMap();
        for (List<String> account: accounts) {
            String name = "";
            for (String email: account) {
                if (name == "") {
                    name = email;
                    continue;
                }
                graph.computeIfAbsent(email, x-> new ArrayList<String>()).add(account.get(1));
                graph.computeIfAbsent(account.get(1), x-> new ArrayList<String>()).add(email);
                emailToName.put(email, name);
            }
        }

        Set<String> seen = new HashSet();
        List<List<String>> ans = new ArrayList();
        for (String email: graph.keySet()) {
            if (!seen.contains(email)) {
                seen.add(email);
                Stack<String> stack = new Stack();
                stack.push(email);
                List<String> component = new ArrayList();
                while (!stack.empty()) {
                    String node = stack.pop();
                    component.add(node);
                    for (String nei: graph.get(node)) {
                        if (!seen.contains(nei)) {
                            seen.add(nei);
                            stack.push(nei);
                        }
                    }
                }
                Collections.sort(component);
                component.add(0, emailToName.get(email));
                ans.add(component);
            }
        }
        return ans;
    }
}

// Approach 2: Union Find
// Time Complexity: O(AlogA), where A=∑ai, and ai is the length of accounts[i].
// If we used union-by-rank, this complexity improves to O(A)O(Aα(A))≈O(A),
// where α is the Inverse-Ackermann function.
// Space Complexity: O(A), the space used by our DSU structure.
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> results = new LinkedList<>();
        UnionFind uf = new UnionFind();
        
        // Construct a mapping from email to person's name
        Map<String, String> emailToName = new HashMap<>();
        Map<String, Integer> emailToId = new HashMap<>();
        int id = 0;
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                emailToName.put(account.get(i), name);
                if (!emailToId.containsKey(email)) {
                    emailToId.put(email, id++);
                }
                uf.union(emailToId.get(account.get(1)), emailToId.get(email));
            }
        }
        
        Map<Integer, List<String>> ans = new HashMap();
        for (String email: emailToName.keySet()) {
            int index = uf.find(emailToId.get(email));
            ans.computeIfAbsent(index, x-> new ArrayList()).add(email); //利用computeIfAbsent减少了rootToChild Map的使用
        }
        for (List<String> component: ans.values()) {
            Collections.sort(component);
            component.add(0, emailToName.get(component.get(0)));
        }
        return new ArrayList(ans.values());
    }
    
    public class UnionFind {
        int[] id;
        public UnionFind() {
            id = new int[10001]; //题中限制条件，可以在不知道size的情况下简历union find
            for (int i = 0; i < 10001; i++) {
                id[i] = i;
            }
        }
        public int find(int p) {
            int root = id[p];
            while (root != id[root]) {
                root = id[root];
            }
            return root;
        }
        public void union(int p, int q) {
            int root1 = find(p);
            int root2 = find(q);
            if (root1 == root2) {
                return;
            }
            id[root1] = root2;
        }
    }
}
