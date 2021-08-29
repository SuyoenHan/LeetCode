class Solution {
    public int reverse(int x) {
        
        // x가 음수인지 양수인지 확인
        String sx = String.valueOf(x);
        Boolean isMinus = false;
        if (x < 0) {
          isMinus = true;
          sx = sx.substring(1);
        }

        // 입력받은 x가 한자리인지 판단
        if (sx.length() < 2) {
          return x;
        }

        char[] sxArr = sx.toCharArray();
        // 입력받은 x가 2자리 이상인 경우 REVERSE
        for (int i = 0; i < sxArr.length / 2; i++) {
          char temp = sxArr[i];
          sxArr[i] = sxArr[sxArr.length - 1 - i];
          sxArr[sxArr.length - 1 - i] = temp;
        }

        String reverseSx = String.valueOf(sxArr);
        try {
          int answer = Integer.parseInt(reverseSx);
          return (isMinus) ? answer * -1 : answer;
        } catch (Exception e) {
          return 0;
        }
    }
}