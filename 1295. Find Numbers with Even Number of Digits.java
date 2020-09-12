// Array
// My solution
// O(n), O(1)
class Solution {
    public int findNumbers(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (containsEvenDigits(nums[i])) {
                result++;
            }
        }
        return result;
    }
    
    public boolean containsEvenDigits(int num) {
        int count = 0;
        while (num >= 1)
        {
            count++;
            num = num / 10;
        }
        return count % 2 == 0;
    }
}

// Approach 1: 利用限制条件
// O(n), O(1)
class Solution {
    public int findNumbers(int[] nums) {
        
        int count=0;
        
        for(int i =0 ; i< nums.length; i++){
            
            if((nums[i]>9 && nums[i]<100) || (nums[i]>999 && nums[i]<10000)){
                count++;
            }
        }
        
        return count;
        
    }
}

// Approach 2
// O(n), O(1)
class Solution {
    public int findNumbers(int[] nums) {
        int cnt = 0;
        for (int n : nums)
            cnt += 1 - Integer.toString(n).length() % 2;
        return cnt;
    }
}

// Approach 3
// O(n), O(1)
public int findNumbers(int[] nums) {
	int sol = 0;                            // Solution variable initialised to 0
	for(int n : nums)                       // Iterate over each number
		if(getNumberOfDigits(n) % 2 == 0)   // Call getNumberOfDigits which return the total number of digits in the number
			sol++;                          // if even number of digits are returned we increment sol by 1
	return sol;                             
}

public int getNumberOfDigits(int num) {
	int count = 1;                          // Initialise count to 1, not 0 cause we are dividing num/10 in while loop
	while((num /= 10) != 0)                 // Iterate until number is 0
		count++;                            // Increment count until number is 0
	return count;
}
