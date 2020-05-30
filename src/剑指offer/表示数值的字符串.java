package 剑指offer;

/**
 * Created by htFly on 2020/5/29.
 */
public class 表示数值的字符串 {
    public boolean isNumeric(char[] str) {
        //signal表示符号，decimal表示小数点，hasE表示含有e
        boolean signal = false, decimal = false, hasE = false;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'E' || str[i] == 'e') {
                //e后面有数字，所以e是最后一位肯定不通过
                if (i == str.length - 1) {
                    return false;
                }
                if (hasE) {
                    return false;
                }
                hasE = true;
            } else if (str[i] == '+' || str[i] == '-') {
                if (signal && str[i - 1] != 'E' && str[i - 1] != 'e') {
                    return false;
                }
                if (!signal && i > 0 && str[i - 1] != 'E' && str[i - 1] != 'e') {
                    return false;
                }
                signal = true;
            } else if (str[i] == '.') {
                if (hasE){

                        return false;

                }
                if (decimal) {
                    return false;
                }
                decimal = true;
            } else if (str[i] < '0' || str[i] > '9') {
                return false;
            }
        }
        return true;
    }
}
