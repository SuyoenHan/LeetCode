class Solution {
     public List<List<Integer>> threeSum(int[] nums) {
	        
	        // 세 수의 합이 0이 되는 리스트 구하기
			List<List<Integer>> answerList= new ArrayList<>();
			List<Integer> eachList= null;
	        
			// 1) 빈배열이 주어진 경우 && 2) 배열의 숫자가 2개 이하인 경우 
			if(nums.length<=2) {
				return answerList;
			}
		
			// 3) 투포인터로 구하기 
			Arrays.sort(nums); // 왼쪽을 이동시킬지 오른쪽을 이동시킬지 정하는 기준
         
			System.out.println(nums);
			int left= 0;
			int right= nums.length-1;
			
			for(int i=1;i<nums.length-1;i++) {
				left=0;  // 초기화
                right= nums.length-1;
                
				while(right>i && left<i) {
					if(nums[left]+nums[i]+nums[right]==0) {
						eachList= new ArrayList<>(3); // runtime 향상을 위해 배열크기 지정
						eachList.add(nums[left]);
						eachList.add(nums[i]);
						eachList.add(nums[right]);
                        Collections.sort(eachList);
						if(!answerList.contains(eachList)) answerList.add(eachList);
					}
					if(nums[left]+nums[i]+nums[right]>0) right--;
					else left++;
				} // end of while(left<i || right>i) {--------
			}
			
			return answerList;
	  }
}