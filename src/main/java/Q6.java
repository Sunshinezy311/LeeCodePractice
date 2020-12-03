public class Q6 {
    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuffer res = new StringBuffer();
        int T = 2 * numRows - 2;
        for (int row = 0; row < numRows; row++) {
            int mod = row % (numRows - 1);
            int d = 0;
            while (d * T + row < s.length()) {
                res.append(s.charAt(d * T + row));
                for (int i = 0; i < numRows - 1; i++) {
                    if (i == numRows - 1 - mod) {
                        int index = (d + 1) * T - mod;
                        if (index < s.length()) {
                            res.append(s.charAt(index));
                        }
                    } else {
                        res.append(" ");
                    }
                }

                d++;
            }
            res.append("\n");

        }

        String out = res.toString();
        System.out.println(out);
        return out.replace(" ", "").replace("\n", "");

    }

    public static void main(String[] args) {
        System.out.println(convert("LEETCODEISHIRING", 2));
        System.out.println(convert("LEETCODEISHIRING", 3));
        System.out.println(convert("LEETCODEISHIRING", 4));
    }
}
