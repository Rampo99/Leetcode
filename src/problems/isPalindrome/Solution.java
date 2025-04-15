package problems.isPalindrome;

public class Solution {
    public boolean isPalindrome(int x) {
        String myNum = String.valueOf(x);
        String str = new StringBuilder(myNum).reverse().toString();
        return str.equals(myNum);
    }
}
