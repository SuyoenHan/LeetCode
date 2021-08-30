class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        
        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        int count = 0; // pixel수
        int lines = 0; // line수

        for (int i = 0; i < s.length(); i++) {
            int index = lowerAlphabet.indexOf(s.charAt(i) + "");
            if (count+widths[index] > 100) {
                lines++;
                count=0;
            }
            count+=widths[index];
        } // end of for------------------------------------
     
        if(count>0){
            lines++; 
        }

        return new int[] { lines, count };
        
    }
}