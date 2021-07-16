class Solution {
     public int maxProfit(int[] prices) {
	        
		 // 가격이 가장 낮을 때 주식을 사고, 가격이 가장 높을 때 주식 팔기 (배열순서는 날짤르 의미하며, 이익을 낼 수 없을경우 0)
		 
		 // 1) 최소값과 최대값 갱신  => 이중for문 사용시 time limit exceeded 
		 int buyPrice=prices[0];
		 int maxProfit=0;
		 
		 for(int i=0;i<prices.length;i++) {
			 
			 buyPrice=Math.min(buyPrice, prices[i]);
			 maxProfit=Math.max(maxProfit, prices[i]-buyPrice);
		 }
		 
		 return maxProfit;
		
	 } // end of  public int maxProfit(int[] prices) {------------
}