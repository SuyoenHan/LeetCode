class Solution {
    public int maxPower(String s) {
        int maxLength = 1;  // 한글자인 경우 고려
        int subLength = 1;
        for (int i = 1; i < s.length(); i++) {
          if (s.charAt(i - 1) == s.charAt(i)) {
            subLength++;
          } else {
            maxLength = (maxLength > subLength) ? maxLength : subLength;
            subLength = 1;
          }
        }
        maxLength = (maxLength > subLength) ? maxLength : subLength; // 최종 maxLength
        return maxLength;
    }
}