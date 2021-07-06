class Solution {
    public void reverseString(char[] s) {
        
		 int len=s.length;
		 char temp=' '; // 값 바꾸기용
		 
		 // 1) 주어진 배열의 중심을 기준으로 값 교체하기
		 for(int i=0;i<len/2;i++) {
			 temp=s[i];
			 s[i]=s[len-(i+1)];
			 s[len-(i+1)]=temp;
		 }
        
    } // end of public void reverseString(char[] s) {--------
}