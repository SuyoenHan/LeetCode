class Solution {
     public int arrayPairSum(int[] nums) {

         // 배열을 2개씩 짝지었을때 min값들의 max합 

         // 1) max합을 구하기=> 작은수끼리 순차적으로 묶어주기
         Arrays.sort(nums);

         int max=0;
         for(int i=0;i<nums.length-1;i+=2) {
             max+=nums[i];
         }

         return max;
	 }
}