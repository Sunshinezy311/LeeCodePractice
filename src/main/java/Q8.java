import java.util.HashMap;
import java.util.Map;

public class Q8 {
    public static int myAtoi(String s) {
        if (s == null || s.length() == 0) return 0;
        boolean isPositive = true;
        boolean isBegin = false;
        int res = 0;
        for (char c : s.toCharArray()) {
            if ('-' == c && !isBegin) {
                isPositive = false;
                isBegin = true;
                continue;
            }
            if ('+' == c && !isBegin) {
                isBegin = true;
                continue;
            }
            if (' ' == c && !isBegin) {
                continue;
            }
            if (Character.isDigit(c)) {
                int num = Character.getNumericValue(c);
                if (isPositive) {
                    isBegin = true;
                    if (res < Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && num < 7)) {
                        res = res * 10 + num;
                    } else {
                        return Integer.MAX_VALUE;
                    }
                } else {
                    if (res > Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && num < 8)) {
                        res = res * 10 - num;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                }
            } else {
                break;
            }
        }
        return res;
    }

    public static int myAtoi1(String str) {
        Automaton automaton = new Automaton();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            automaton.get(str.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }

    public static void main(String[] args) {
        System.out.println(myAtoi1("2147483646"));
        System.out.println(myAtoi1("4193 with words"));
        System.out.println(myAtoi1("words and 987"));
        System.out.println(myAtoi1("-91283472332"));
        System.out.println(myAtoi1("+-12"));
        System.out.println(myAtoi1("-+12"));
        System.out.println(myAtoi1("   +0 123"));
    }
}

class Automaton {
    public int sign = 1;
    public long ans = 0;
    private String state = "start";
    private final Map<String, String[]> table = new HashMap<String, String[]>() {{
        put("start", new String[]{"start", "signed", "in_number", "end"});
        put("signed", new String[]{"end", "end", "in_number", "end"});
        put("in_number", new String[]{"end", "end", "in_number", "end"});
        put("end", new String[]{"end", "end", "end", "end"});
    }};

    public void get(char c) {
        state = table.get(state)[get_col(c)];
        if ("in_number".equals(state)) {
            ans = ans * 10 + c - '0';
            ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
        } else if ("signed".equals(state)) {
            sign = c == '+' ? 1 : -1;
        }
    }

    private int get_col(char c) {
        if (c == ' ') {
            return 0;
        }
        if (c == '+' || c == '-') {
            return 1;
        }
        if (Character.isDigit(c)) {
            return 2;
        }
        return 3;
    }
}
