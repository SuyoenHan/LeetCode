class Solution {
    public int[] twoSum(int[] nums, int target) {
		
		// 1) target-각 배열의 값을 맵에 저장 
		Map<Integer,Integer> map= new HashMap<>();
		
		for(int i=0;i<nums.length;i++) {
			map.put(target-nums[i], i); // key값과 value값을 바꾸면 같은 인덱스의 값인지 판단할 수 없다
		}
		
		int[] answerArr= null; 
		// 2) 맵에 저장된 키값이 존재하는지 확인
		for(int i=0;i<nums.length;i++) {
			if(map.containsKey(nums[i]) && map.get(nums[i])!=i) { // 같은 인덱스의 값은 중복사용 불가
				answerArr= new int[] {map.get(nums[i]),i};
				break;
			}
		}
		
		return answerArr;
		
	} // end of public int[] twoSum(int[] nums, int target) {----
}