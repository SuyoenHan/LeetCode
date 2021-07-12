class Solution {
   	 public static String longestPalindrome(String s) {
	        
		 // 주어진 문자열은 숫자와 영어(대소문자)로만 구성
		 // 가장 긴 팰린드롬 부분 문자열 구하기
		 
		 // 중심점에서 문자 확장하기
		 // 1) 짝수 팰린드롬을 고려하기 위해 "#"을 중간중간 넣어주기
		 char[] sArr= s.toCharArray();
		 char[] newArr= new char[s.length()*2+1];
		 
		 for(int i=0;i<sArr.length;i++) {
			newArr[2*i+1]=sArr[i];  // 1 3 5 7 9
			newArr[2*i]= '#';   
		 } // end of  for(int i=0;i<sArr.length;i++) {------
		 newArr[s.length()*2]= '#';
         
		 // 2) 각 인덱스 별로 확장 문자 개수 넣어줄 배열 생성
		 int[] indexArr= new int[newArr.length];
		 for(int i=0, radius=0;i<newArr.length;i++) {
			 radius=0;
             
			 if(i==0) indexArr[i]=0;
			 else {
				 while(true) {
					 if(i-radius-1>0 && i+radius+1<newArr.length && newArr[i-radius-1]==newArr[i+radius+1]) { // 팰린드롬인 경우
						
                         radius++;  
						 continue;
					 }
					 else {
						 break; // 확장 중지
					 }
				 }
				 indexArr[i]=radius;
                 // System.out.println(i+"  "+indexArr[i]);
			 }
		 } // end of  for(int i=0;i<newArr.length;i++) {--------
		 
		 // 3) 최대 숫자가 0인 경우 첫번재 문자 반환
		 int maxRadius=0;
		 int centerindex=0;
		 for(int i=0;i<indexArr.length;i++) {
			 if(maxRadius<indexArr[i]) {
				 maxRadius=indexArr[i];
				 centerindex=i;
			 }
		 }

         //System.out.println(centerindex);
         //System.out.println(maxRadius); 
         
		 String palindrome="";
		 if(maxRadius==0)  palindrome=sArr[0]+"";
		 else {
			 palindrome= combineString(centerindex-maxRadius,centerindex+maxRadius,newArr);
		 }
		 return palindrome;
		 
	 } // end of public String longestPalindrome(String s) {----
	 
	 // 문자열 합치는 메서드
	 public static String combineString(int i, int j, char[] newArr) {
		 
		 StringBuilder sb= new StringBuilder();
		 for(int k=i;k<=j;k++) {
			 if(newArr[k]!='#') sb.append(newArr[k]);
		 }
		 
		 return sb.toString();
	 } // end of  public static String combineString(int i, int j, char[] sArr) {----
}