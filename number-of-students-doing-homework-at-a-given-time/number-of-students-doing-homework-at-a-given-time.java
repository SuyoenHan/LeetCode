class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int students= startTime.length;
        int answer= 0;

        for(int i=0;i<students;i++){
          if(startTime[i]<=queryTime && queryTime<=endTime[i]){
            answer++;
          }
        }
        return answer;
    }
}