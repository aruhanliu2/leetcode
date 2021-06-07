/* Arrays, Sort */

// Brute force
// 两次for loop找出最大的combination

// My solution: sorting
// O(nlogn)
class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        // 易错点1：一定要掌握带有comparator的sort的syntax
        // 更简单的写法：Arrays.sort(intervals, (a,b)->Integer.compare(a,b));
        Arrays.sort(intervals, new Comparator<int[]>(){
           public int compare(int[] a1, int[] a2) {
               return a1[0] - a2[0]; //The other way of writing this: return Integer.compare(a1[0],a2[0])
           } 
        });
        // 易错点2：一定要在排序之后在赋值prev
        int[] prev = intervals[0];
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] <= prev[1]) {
                prev[1] = Math.max(intervals[i][1],prev[1]);
            } else {
                list.add(prev);
                prev = intervals[i];
            }
        }
        // 易错点3：不要忘记将最后一个element单独加入
        list.add(prev);
        // 易错点4：掌握将ArrayList转换成int array的格式
        return list.toArray(new int[list.size()][2]);
    }
}

// Solution 1: Sorting (Same as mine)
// O(nlogn)
// O(n) -> extra space declared, space complexity : O(logN) (or O(n))
// If we can sort intervals in place, we do not need more than constant additional space, although the sorting itself takes O(logn) space.
// Otherwise, we must allocate linear space to store a copy of intervals and sort that.
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
