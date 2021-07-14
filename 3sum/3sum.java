class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

            // 세 수의 합이 0이 되는 리스트 구하기
            List<List<Integer>> answerList= new ArrayList<>();
            List<Integer> eachList= null;

            // 1) 빈배열이 주어진 경우 && 2) 배열의 숫자가 2개 이하인 경우 
            if(nums.length<=2) {
                return answerList;
            }

            // 3) 투포인터로 구하기 
            Arrays.sort(nums); // 왼쪽을 이동시킬지 오른쪽을 이동시킬지 정하는 기준

            int left= 0;
            int right= nums.length-1;

            for(int i=0;i<nums.length-2;i++) { // 첫번째 수 
                
                if(i>0 && nums[i]==nums[i-1]) continue; // 중복제거
 
                // 3-1) 두번째 수와 세번째 수 투포인터로 구하기
                left=i+1;
                right= nums.length-1; // 초기화
                while(left<right) {
                    if(nums[left]+nums[i]+nums[right]==0) {
                        eachList= new ArrayList<>(3); // runtime 향상을 위해 배열크기 지정
                        eachList.add(nums[left]);
                        eachList.add(nums[i]);
                        eachList.add(nums[right]);
						answerList.add(eachList);
                    }
                    
                    if(nums[left]+nums[i]+nums[right]>0){ 
                        right--;
                        while(right>left && nums[right]==nums[right+1]) right--;  // 같은 값 제외
                    }    
                    else{
                        left++;
                        while(right>left && nums[left]==nums[left-1]) left++;
                    } 
                } // end of  while(left<right) {-------------------
            } // end of for(int i=0;i<nums.length-2;i++) {--------------

            return answerList;
      }
}