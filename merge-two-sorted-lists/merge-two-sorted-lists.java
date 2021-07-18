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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	     
	 ListNode answer= null;
	 ListNode result= new ListNode(0);  // 시작값
         answer=result;
         
	 // 1) 주어진 linked List가 비어있는 경우 고려 => 삼항연산자 사용 
	 if(l1==null || l2==null) answer.next= (l1==null)?l2:l1;
	 else {
			 
		// 2) 이미 정렬된 l1와 l2의 값 비교
		while(l1!=null && l2!=null) {
                 
			if(l1.val>l2.val) {
				answer.next=l2;
                    		l2=l2.next;
                    		answer=answer.next;
			}
			else {
				answer.next=l1;
                     		l1=l1.next;
                     		answer=answer.next;
			}
		} // end of while(l1!=null && l2!=null) {------
			 
		// 3) 남아있는 값 처리
		if(l1==null) answer.next=l2;
	   	else answer.next=l1;
			 
	} // end of else----------------------
		 
	return result.next;
		 
    } // end of public ListNode mergeTwoLists(ListNode l1, ListNode l2) {---
}
