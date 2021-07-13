class Solution {
     public int trap(int[] height) {
	     
		 int startIndex= 0;
		 int trapCnt=0;
		 
		 // 1) 0 이외의 숫자가 나오는 곳이 시작점
		 for(int i=0;i<height.length;i++) {
			 if(height[i]!=0) {
				 startIndex=i;
				 break;
			 }
		 }
		 
		 // 2) 왼쪽으로 자기 자신보다 큰 수가 있어야하고, 오른쪽으로도 자기 자신보다 큰 수가 있어야 한다
	     for(int i=startIndex+1, position=0; i<height.length-1;i++) {
             
              position=0; // 초기화
             
	    	 // 2-1) index를 기준으로 왼쪽에서 가장 큰 값
	    	 int maxLeft= 0;
	    	 while(i-position>=startIndex) {
	    		 if(height[i]<height[i-position] && maxLeft<height[i-position] ) {
	    			 maxLeft=height[i-position];
	    		 }
                 position++;
	    	 }
	    	 
	    	 position=0; // 초기화
	    	 // 2-2) index를 기준으로 오른쪽에서 가장 큰 값
	    	 int maxRight= 0;
	    	 while(i+position<=height.length-1) {
	    		 if(height[i]<height[i+position] && maxRight<height[i+position] ) {
	    			 maxRight=height[i+position];
	    		 }
                 position++;
	    	 }
	    	 
	    	 
	    	// 3) 왼쪽과 오른쪽 숫자 중에 가장 작은 수-본인수 가 빗물이 고이는 정도
	    	 if(maxLeft!=0 && maxRight!=0) { // 빗물이 고이는 경우
	    		 trapCnt+=Math.min(maxLeft, maxRight)-height[i];
	    	 }
	    	 
	     } // end of for--------------------
	     
	     return trapCnt;
	} // end of public int trap(int[] height) {----------------------
}