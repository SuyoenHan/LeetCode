class Solution {
    public boolean isPalindrome(String s) {
        
        // 1) 알파벳과 숫자 이외의 모든 문자 제외 (only alphanumeric characters)
        String newS= "";
        for(int i=0;i<s.length();i++) {
           if(Character.isAlphabetic(s.charAt(i)) || Character.isDigit(s.charAt(i))) newS+=s.charAt(i);
        } // end of for-------------------------
        
        // 2) 대소문자를 구분하지 않음
	    newS= newS.toLowerCase();     
	    
	    // 3) 팰린드롬인지 판단
	    boolean isPalindrome= true;
	    for(int i=0;i<newS.length();i++) {
	    	
	    	if(newS.charAt(i)!=newS.charAt(newS.length()-(i+1))){
	    		isPalindrome= false;
	    		break;
	    	}
	    } // end of for------------------------
	    
	    return isPalindrome;
        
        
        
    }
}