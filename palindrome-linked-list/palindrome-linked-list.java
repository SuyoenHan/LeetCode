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
		 
       // 2-1) 팰린드롬 검사 할 head		 
	     ListNode pHead= head; 
		 
		  // 1) 스택 사용
		  Stack<Integer> stack= new Stack<>();
		  while(head!=null) {  
			  stack.push(head.val);
			  head=head.next;
		  }
		  
		  // 2) 스택에 쌓인 값들을 이용하여 팰린드롬 판단
		  while(pHead!=null) {
			  if(pHead.val!=stack.peek()) { // 첫번째 값과 마지막 값이 같지 않은 경우 => 팰린드롬이 아니다
				  return false;
			  }
			  else {
				 pHead=pHead.next;
				 stack.pop();
			  }
		  } // end of while(pHead!=null) {------
		  
		  return true;
	} // end of public boolean isPalindrome(ListNode head) {-----------
}