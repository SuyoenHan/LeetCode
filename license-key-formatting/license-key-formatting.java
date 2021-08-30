class Solution {
    public String licenseKeyFormatting(String s, int k) {
       String removeDash= s.replaceAll("-", "");
       String reverseAnswer="";
       int count =0;

       for (int i = removeDash.length() - 1; i >= 0; i--) {
      if (count == k) {
        reverseAnswer += "-";
        count = 0;
      } 
      count++;  
      reverseAnswer += removeDash.charAt(i);
    }

        reverseAnswer = reverseAnswer.toUpperCase();
       String[] reverseArr= reverseAnswer.split("");
       for(int i=0;i<reverseArr.length/2;i++){ // 문자열 뒤집기
            String temp= reverseArr[i];
            reverseArr[i]=reverseArr[reverseArr.length-1-i];
            reverseArr[reverseArr.length-1-i]= temp;
       }

       return String.join("", reverseArr);
    }
}