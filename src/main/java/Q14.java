public class Q14 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String match = strs[0];
        for (int i = 1; i < strs.length; i++) {

            String str = strs[i];
            int j = 0;
            while (j < str.length() && j < match.length() && match.charAt(j) == str.charAt(j)) {
                j++;
            }
            if (j == 0) {
                return "";
            }
            match = match.substring(0, j);
        }
        return match;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }
}
