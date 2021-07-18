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
        
		 // 1) 주어진 linked List가 비어있는 경우 고려 
		 if(l1==null && l2==null) return result.next;
		 
		 if(l1==null && l2!=null) answer.next=l2;
		 else if(l1!=null && l2==null) answer.next=l1;
		 else {
			 
			 // 2) answer의 초기값 잡기
			 if(l1.val>l2.val) {
				 answer.next=l2;
				 l2=l2.next;
			 }
			 else {
				 answer.next=l1;
				 l1=l1.next;
			 }
             
              answer=answer.next;
			 
			 // 3) 이미 정렬된 l1와 l2의 값 비교
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
			 }
			 
			 // 4) 남아있는 값들 순차적으로 넣어주기
			 if(l1==null) {
				 while(l2!=null){
                     answer.next=l2;
                     l2=l2.next;
                     answer=answer.next;
                 }
			 }
			 else {
				 while(l1!=null){
                   answer.next=l1;
                   l1=l1.next;
                   answer=answer.next;
                 } 
			 }
		 }
		 
		 return result.next;
		 
	 } // end of public ListNode mergeTwoLists(ListNode l1, ListNode l2) {---
}