/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
   public boolean isPalindrome(ListNode head) {
	        
		  // 데크 구조로 풀이
		  Deque<Integer> dq= new ArrayDeque<>();
	      boolean answer= true;
	      
	      // 1) 데크에 순차적으로 쌓기
		  while(head!=null) {
			  dq.offer(head.val);
			  head=head.next;
		  }
		  
		  // 2) 데크에 쌓인 값들을 이용하여 팰린드롬 판단
		  while(dq.size()>0) {
			  
			  if(dq.size()==1) {
				  answer=true;
				  break;
			  }
			  
			  if(dq.peekFirst()==dq.peekLast()) { 
				  dq.pollFirst();
				  dq.pollLast();
			  }
			  else { // 팰린드롬이 아닌  경우
				  answer=false;
				  break;
			  }
		  } // end of while(dq.size()>0) {--------
	      return answer;
	      
	} // end of public boolean isPalindrome(ListNode head) {-----------
}