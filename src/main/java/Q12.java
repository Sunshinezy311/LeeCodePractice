import java.util.HashMap;
import java.util.Map;

public class Q12 {
    private static final String[] numBy5=new String[]{"V", "L", "D"};
    private static final String[] numBy10=new String[]{"I", "X", "C", "M"};

    public static String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        int index = 0;
        while (num / 10 > 0) {
            int mod = num % 10;
            result.insert(0, generateRomanChar(index, mod));
            num = num / 10;
            index++;
        }
        result.insert(0, generateRomanChar(index, num % 10));
        return result.toString();
    }

    private static String generateRomanChar(int index, int mod) {
        String value = "";
        //1. 为0，则表示没有可以加的数字，直接不考虑
        //2. 为1-8，则补充数个值
        if (mod > 0) {
            if (mod == 9) {
                value = (numBy10[index]) + (numBy10[index + 1]);
            } else if (mod >= 5) {
                value = (numBy5[index]) + addMultipleString(mod - 5, index);
            } else if (mod == 4) {
                value = (numBy10[index]) + (numBy5[index]);
            } else {
                value = addMultipleString(mod, index);
            }
        }
        return value;
    }

    private static String addMultipleString(int time, int index) {
        StringBuilder value = new StringBuilder();
        for (int i = 0; i < time; i++) {
            value.append(numBy10[index]);
        }
        return value.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(4));
        System.out.println(intToRoman(9));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));
        System.out.println(intToRoman(44));
        System.out.println(intToRoman(99));
        System.out.println(intToRoman(444));
        System.out.println(intToRoman(999));
    }
}
