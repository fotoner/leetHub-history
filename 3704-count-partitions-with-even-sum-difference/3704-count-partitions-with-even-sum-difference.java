class Solution {
    public int countPartitions(int[] nums) {
        int leftSum = 0;
        int rightSum = 0;
        int count = 0; 
        
        for(int i = 0; i < nums.length; i++) {
            rightSum += nums[i];
        }

        for (int i = 0; i < nums.length - 1; i++) {
            int curValue = nums[i];
            leftSum += curValue;
            rightSum -= curValue;

            if((leftSum - rightSum) % 2 == 0) {
                count++;
            }
        }

        return count;
    }
}