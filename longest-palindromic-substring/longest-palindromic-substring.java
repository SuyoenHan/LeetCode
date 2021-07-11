class Solution {
    public String longestPalindrome(String s) {
	        
		 // 주어진 문자열은 숫자와 영어(대소문자)로만 구성
		 // 가장 긴 팰린드롬 부분 문자열 구하기
		 
		 char[] sArr= s.toCharArray();
		 
		 int length=1;
		 String longPalindromeWord= String.valueOf(sArr[0]);
		 boolean flag= false; // 팰린드롬 판단 (true일 경우 팰린드롬이 아니다)
		 
		 // 1) 팰린드롬 문자의 시작부분과 끝 부분 index 번호 구하기
		 for(int i=0;i<s.length()-1;i++) {
			 for(int j=i+1;j<s.length();j++) {
                 flag= false; // 초기화
                 
				 if(sArr[i]==sArr[j]) { // 2) 부분문자열의 시작과 끝 index
                     
                     // System.out.println(i +"  "+j);
                     
                     // 3) 그 사이의 문자열이 팰린드롬인지 확인
					 for(int k=i, m=0;k<=j;k++) {
						 if(sArr[k]!=sArr[j-m]){
                             flag=true;
                             break;
                         }
                         m++;
					 }
					 
					 if(!flag && (j-i+1) > length) { // 팰린드롬이면서 길이가 긴 경우
                             //System.out.println("변경");
							 length= j-i+1;
							 longPalindromeWord= combineString(i,j, sArr); // 문자열 합치는 메서드
					 }
					 
				 } // end of if(sArr[i]==sArr[j]) { -----
			 } // end of for(int j=i+1;j<s.length();j++) {-----
		 } // end of for(int i=0;i<s.length();i++) {-----
		 
		 
		 return longPalindromeWord;
	 } // end of public String longestPalindrome(String s) {----
	 
	 // 문자열 합치는 메서드
	 public static String combineString(int i, int j, char[] sArr) {
		 
		 StringBuilder sb= new StringBuilder();
		 for(int k=i;k<=j;k++) sb.append(sArr[k]);
		 
		 return sb.toString();
	 } // end of  public static String combineString(int i, int j, char[] sArr) {----
}