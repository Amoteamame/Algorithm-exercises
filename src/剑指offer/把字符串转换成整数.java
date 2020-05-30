package 剑指offer;

/**
 * Created by htFly on 2020/5/27.
 */
public class 把字符串转换成整数 {
    public int StrToInt(String str) {
        boolean state = true;
        char[] s = str.toCharArray();
        int sum = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '+') {
                continue;
            } else if (s[i] == '-') {
                state = false;
                continue;
            } else if (s[i] < '0' || s[i] > '9') {
                return 0;
            }
            sum = sum * 10 + (int) (s[i] - '0');
            if ((!state && sum > Integer.MAX_VALUE) || (state && sum < Integer.MIN_VALUE)) {
                sum = 0;
                break;
            }
        }
        if (sum == 0) {
            return 0;
        }
        return state == true ? sum : -sum;
    }

    public static void main(String[] args) {
        System.out.println( Integer.MAX_VALUE);
    }
}
