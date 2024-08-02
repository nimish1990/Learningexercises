package leetcode.problems.problem2678;

import java.util.Arrays;

class Solution {

     public int countSeniors(String[] details) {

         return (int) Arrays.stream(details).filter(detail -> Integer.parseInt(detail.substring(11, 13)) > 60).count();

    }

    public static void main(String[] args) {
        String [] details = {"7868190130M7522","5303914400F9211","9273338290F4010"};
        String [] details1 = {"1313579440F7536","2921522980M5644"};
        Solution solution= new Solution();
        System.out.println(solution.countSeniors(details));
        System.out.println(solution.countSeniors(details1));
    }
}
