class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones == null) {
            return 0;
        }
        PriorityQueue<Integer> queue =
            new PriorityQueue<>(stones.length, new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });
        for(int i = 0; i < stones.length; i++) {
            queue.add(stones[i]);
        }
        while(queue.size() > 1) {
            int a = queue.poll();
            int b = queue.poll();
            queue.add(Math.abs(a - b));
        }
        if(queue.size() == 1) {
            return queue.poll();
        }
        return 0;
    }
}
