class Solution {
    public int[] twoSum(int[] nums, int target) {
		
		int needNum=0;
		int[] answerArr= new int[2];
		
		// 1) target-특정값에 해당하는 값이 있는지 확인
		for(int i=0;i<nums.length-1;i++) {
			needNum=target-nums[i];
			for(int j=i+1;j<nums.length;j++) {
				if(needNum==nums[j]) {
					answerArr[0]=i;
					answerArr[1]=j;
				}
			}
		} // end of for(int i=0;i<nums.length-1;i++) {----------
		
		return answerArr;
	} // end of public int[] twoSum(int[] nums, int target) {----
}