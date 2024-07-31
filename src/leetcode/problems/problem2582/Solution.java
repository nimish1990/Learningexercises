package leetcode.problems.problem2582;

class Solution {
    public int passThePillow(int n, int time) {
        int position = 1; // Starting position
        int direction = 1; // 1 for right, -1 for left

        for (int i = 0; i < time; i++) {
            position += direction;

            // Change direction if we hit either end
            if (position == n) {
                direction = -1; // Change direction to left
            } else if (position == 1) {
                direction = 1; // Change direction to right
            }
        }

        return position;
    }

    public static void main(String[] args) {
       System.out.println(new Solution().passThePillow(4, 5));
    }
}