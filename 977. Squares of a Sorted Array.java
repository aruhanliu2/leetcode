// Array
// My solution
// O(n), O(n)
class Solution {
    public int[] sortedSquares(int[] A) {
        int i = 0, j = A.length - 1;
        int[] result = new int[A.length];
        int count = A.length - 1;
        while (i <= j) {
            if (A[i] * A[i] <= A[j] * A[j]) {
                result[count--] = A[j] * A[j];
                j--;
            } else {
                result[count--] = A[i] * A[i];
                i++;
            }
        }
        return result;
    }
}

// Approach 1
// O(nlogn), O(n)
class Solution {
    public int[] sortedSquares(int[] A) {
        int N = A.length;
        int[] ans = new int[N];
        for (int i = 0; i < N; ++i)
            ans[i] = A[i] * A[i];

        Arrays.sort(ans);
        return ans;
    }
}

// Approach 2
// O(n), O(n)
class Solution {
    public int[] sortedSquares(int[] A) {
        int N = A.length;
        int j = 0;
        while (j < N && A[j] < 0)
            j++;
        int i = j-1;

        int[] ans = new int[N];
        int t = 0;

        while (i >= 0 && j < N) {
            if (A[i] * A[i] < A[j] * A[j]) {
                ans[t++] = A[i] * A[i];
                i--;
            } else {
                ans[t++] = A[j] * A[j];
                j++;
            }
        }

        while (i >= 0) {
            ans[t++] = A[i] * A[i];
            i--;
        }
        while (j < N) {
            ans[t++] = A[j] * A[j];
            j++;
        }

        return ans;
    }
}
