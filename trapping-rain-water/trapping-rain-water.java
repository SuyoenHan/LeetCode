class Solution {
     public int trap(int[] height) {
	     
	// 투포인터 방법으로 접근 => 왼쪽 끝과 오른쪽 끝에서 최대지점으로 좁혀오기
	int leftIndex=0;
	int rightIndex=height.length-1;
		 
        // 빈 배열인 경우 고려
        if(height.length==0) return 0;
         
	int maxLeft=height[leftIndex];
	int maxRight=height[rightIndex];
		 
	int trapCnt=0;
	while(leftIndex<rightIndex) { // leftIndex와 rightIndex는 겹치면 안된다
			 
		if(maxLeft<=maxRight) { // 오른쪽이 더 높은 경우
			trapCnt+=maxLeft-height[leftIndex];
			leftIndex++;
		}
		else { // 왼쪽이 더 높은 경우
			trapCnt+=maxRight-height[rightIndex];
			rightIndex--;
		}
				 
		// 최대점 갱신
		maxLeft= Math.max(maxLeft, height[leftIndex]);
		maxRight= Math.max(maxRight, height[rightIndex]);
	}
	     return trapCnt;
	} // end of public int trap(int[] height) {----------------------
}
