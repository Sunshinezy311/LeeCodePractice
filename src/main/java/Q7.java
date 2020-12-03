public class Q7 {
    public static int reverse(int x) {
        char[] s = String.valueOf(x).toCharArray();
        int length = s.length;
        boolean isNegative = (s[0] == '-');
        int i = 0;
        if (isNegative) {
            i = 1;
            length++;
        }
        while (i < length / 2) {
            char temp = s[i];
            s[i] = s[length - i - 1];
            s[length - i - 1] = temp;
            i++;
        }

        try {
            return Integer.parseInt(String.valueOf(s));
        } catch (Exception e) {
            return 0;
        }
    }

    public static int reverse1(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123456));
        System.out.println(reverse(-123456));
        System.out.println(reverse(-1234567890));
        System.out.println(reverse1(-1234567899));
    }
}
