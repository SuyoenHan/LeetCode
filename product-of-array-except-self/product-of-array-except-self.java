class Solution {
  public int[] productExceptSelf(int[] nums) {
        
		// 자신을 제외한 곱
		// 1) 곱 한 결과물을 넣을 배열 생성
		int[] answerArr= new int[nums.length];
		List<Integer> zeroIndex= new ArrayList<>(nums.length);
		
		// 2) 자신을 제외한 수 곱하기 => 모든 수 곱한 값에서 자신 나누기
		int totalProduct= 1;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]!=0) totalProduct*=nums[i];
			else { // 2-1) 0인 경우 index따로 기억시켜두기
				zeroIndex.add(i);
			}
		}
		

		// 3-1) 배열에 0이 2개이상 존재하는 경우=> 모든 값은 0 
		if(zeroIndex.size()>=2) Arrays.fill(answerArr, 0);
		else if(zeroIndex.size()==1) {  // 3-2) 0이 1개 존재하는 경우=> 0인 값을 제외하고 나머지 값은 다 0
			Arrays.fill(answerArr, 0);
			answerArr[zeroIndex.get(0)]=totalProduct;
		}
		else { // 3-3) 0이 존재하지 않는 경우
			for(int i=0;i<nums.length;i++) {
				answerArr[i]=totalProduct/nums[i];
			}
		}
		
		return answerArr;
    } // end of public int[] productExceptSelf(int[] nums) {----
}