public class Q5 {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int begin = 0;
        int end = 0;
        int maxLength = 1;
        int length = s.length();
        boolean[][] dp = new boolean[length][length];

        for (int j = 0; j < length; j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    //同一个字符，则为true
                    if (i == j) {
                        dp[i][j] = true;
                    }
                    if (j - i == 1 ||  //两个连续的字符，则为true
                            i + 1 <= j - 1 && dp[i + 1][j - 1]) {//一直第i个和第j个相等，如果小一圈也满足，则为true
                        dp[i][j] = true;
                        if (maxLength < j - i + 1) {
                            begin = i;
                            end = j;
                            maxLength = j - i + 1;
                        }
                    }
                }
            }
        }
        return s.substring(begin, end + 1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("abac"));
        System.out.println(longestPalindrome("ccabac"));
        System.out.println(longestPalindrome("ddddcabac"));
    }
}
