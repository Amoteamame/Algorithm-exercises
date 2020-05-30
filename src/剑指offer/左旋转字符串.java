package 剑指offer;

import java.util.Scanner;

/**
 * Created by htFly on 2020/5/26.
 */
public class 左旋转字符串 {
    public static String LeftRotateString(String str, int n) {
        if (str.length() < n) {
            return "";
        }
        String str1 = str.substring(0, n);
        String str2 = str.substring(n, str.length());
        return str2 + str1;
    }

    // 三次翻转后可得结果
    public static String LeftRotateString2(String str, int n) {
        char[] chars = str.toCharArray();
        if (chars.length < n) {
            return "";
        }
        reverse(chars, 0, n-1);
        reverse(chars, n, chars.length-1);
        reverse(chars, 0, chars.length-1);
        StringBuilder sb = new StringBuilder(chars.length);
        for (char c : chars) {
            sb.append(c);
        }
        return sb.toString();
    }

    private static void reverse(char[] chars, int low, int high) {
        char temp;
        while (low < high) {
            temp = chars[low];
            chars[low] = chars[high];
            chars[high] = temp;
            low++;
            high--;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
//        System.out.println(LeftRotateString(str, 3));
        System.out.println(LeftRotateString2(str, 3));
    }
}
