package leetcode.problems.problem2181;



class Solution {
    public static ListNode mergeNodes(ListNode head) {

        ListNode current = head.next; //Skip Initial zero
        ListNode sumNode = current;
        while(sumNode!=null){
            int sum=0;
            while(sumNode.val !=0){
                sum += sumNode.val;
                sumNode= sumNode.next;
            }
            current.val=sum;
            sumNode= sumNode.next;
            current.next= sumNode;
            current=current.next;
        }

        return head.next;

    }


    public static void main(String[] args) {
        int[] values = {0, 3, 1, 0, 4, 5, 2, 0};

        // Create the head of the list
        ListNode head = new ListNode(values[0]);
        ListNode current = head;

        // Iterate through the rest of the values and create nodes
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        mergeNodes(head);
    }


}