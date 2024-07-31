package leetcode.problems.problem2058;


import leetcode.problems.problem2181.ListNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = curr.next;

        List<Integer> criticalPoints = new ArrayList<>();
        int position = 1; // Position of the current node (1-indexed)

        while (next != null) {
            if ((curr.val < prev.val && curr.val < next.val) || (curr.val > prev.val && curr.val > next.val)) {
                criticalPoints.add(position);
            }
            prev = curr;
            curr = next;
            next = next.next;
            position++;
        }

        if (criticalPoints.size() < 2) {
            return new int[]{-1, -1};
        }

        int minDistance = Integer.MAX_VALUE;
        int maxDistance = criticalPoints.get(criticalPoints.size() - 1) - criticalPoints.get(0);

        for (int i = 1; i < criticalPoints.size(); i++) {
            int distance = criticalPoints.get(i) - criticalPoints.get(i - 1);
            if (distance < minDistance) {
                minDistance = distance;
            }
        }

        return new int[]{minDistance, maxDistance};

    }


    public static void main(String[] args) {
        int[] values = {5, 3, 1, 2, 5, 1, 2};

        // Create the head of the list
        ListNode head = new ListNode(values[0]);
        ListNode current = head;

        // Iterate through the rest of the values and create nodes
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        int[] result = nodesBetweenCriticalPoints(head);

        // Print the result for verification
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }


}