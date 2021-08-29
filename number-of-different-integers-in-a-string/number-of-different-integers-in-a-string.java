class Solution {
    public String modifyNumber(String snumber) {
    int startIndex = -1;
    for (int i = 0; i < snumber.length(); i++) {
      if (snumber.charAt(i) != '0') {
        startIndex = i;
        break;
      }
    }

    if (startIndex == -1) { // 0으로만 이루어진 경우
      return "0";
    } else {
      return snumber.substring(startIndex);
    }
  }

  public int numDifferentIntegers(String word) {
    char[] wordArr = word.toCharArray();
    HashSet<String> answerSet = new HashSet<>(); // 중복허용안함

    String snumber = "";

    for (char c : wordArr) {
      if (c < (char) '0' || c > (char) '9') { // 숫자가 아닌경우
        if (snumber.length() >= 1) {
          answerSet.add(modifyNumber(snumber));
          snumber = "";
        }
      } else { // 숫자인경우
        snumber += c;
      }
    } // end of for-------------------------------

    // 마지막 문자까지 숫자인 경우
    if (wordArr[word.length() - 1] >= (char) '0' && wordArr[word.length() - 1] <= (char) '9') {
      answerSet.add(modifyNumber(snumber));
    }

    return answerSet.size();
  }
}