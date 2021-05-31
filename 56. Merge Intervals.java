class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
           public int compare(int[] a, int[] b) {
               return Integer.compare(a[0], b[0]);
           } 
        });
        
        List<int[]> result = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] > end) {
                result.add(new int[]{start,end});
                start = intervals[i][0];
            }
            end = Math.max(intervals[i][1],end);
        }
        result.add(new int[]{start,end});
        int[][] finalResult = new int[result.size()][2];
        for(int i = 0; i < result.size(); i++){
            finalResult[i] = result.get(i);
        }
        return finalResult;
    }
}
