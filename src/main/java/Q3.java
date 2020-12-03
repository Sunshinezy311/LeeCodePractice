import java.util.HashSet;
import java.util.Set;

public class Q3 {
    public static int lengthOfLongestSubstring(String s) {
        Set<Byte> subStringSet = new HashSet<>();
        int len = 0;
        byte[] bytes = s.getBytes();

        for (int i = 0; i < bytes.length; i++) {
            byte b = bytes[i];
            subStringSet.clear();
            int j = i;
            while (j < bytes.length && !subStringSet.contains(bytes[j])) {
                subStringSet.add(bytes[j]);
                j++;
            }
            // j 多算了一位（j++了），j-i本来要加1，因此抵消了
            len = Math.max(len, j - i);
        }
        return len;
    }

    public static int lengthOfLongestSubstring1(String s) {
        Set<Byte> subStringSet = new HashSet<>();
        int len = 0;
        byte[] bytes = s.getBytes();

        // j的结果不要在过程中置为0，可以在现有的基础上继续统计，这样免去了多余的计算
        int j = -1;
        for (int i = 0; i < bytes.length; i++) {
            // 从第二位以及之后开始遍历时，需要把之前的一个元素删除
            if (i > 0) {
                subStringSet.remove(bytes[i - 1]);
            }

            while (j + 1 < bytes.length && !subStringSet.contains(bytes[j + 1])) {
                subStringSet.add(bytes[j + 1]);
                j++;
            }
            len = Math.max(len, j - i +1);
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring1("dvdf"));
        System.out.println(lengthOfLongestSubstring1("abcabcbb"));
        System.out.println(lengthOfLongestSubstring1("pwwkew"));
        System.out.println(lengthOfLongestSubstring1("bbbbb"));

        System.out.println(lengthOfLongestSubstring("dvdf"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
    }
}
