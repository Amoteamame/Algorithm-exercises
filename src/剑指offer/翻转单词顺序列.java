package 剑指offer;

import java.util.Scanner;
import java.util.Stack;

/**
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 */
public class 翻转单词顺序列 {
    public static String ReverseSentence(String str) {
        if (str.trim().equals("") && str.length() > 0) {
            return str;
        }
        Stack<String> stack = new Stack();
        String result = " ";
        String[] results = str.split(" ");
        for (int i = 0; i < results.length; i++) {
            stack.push(results[i]);
        }
        result = stack.pop();
        while (!stack.isEmpty()) {
            result += " " + stack.pop();
        }
        return result;
    }

    public static String ReverseSentence2(String str) {
        char[] chars = str.toCharArray();
        reverse(chars, 0, chars.length - 1); //先反转整个数组
        int blank = -1; //记录空格位置,依据空格来确定单词的起始和终止位置
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                int nextBlank = i;
                reverse(chars, blank + 1, nextBlank - 1);
                blank = i;
            }
        }
        reverse(chars, blank+1, chars.length-1);//最后一个单词单独进行反转,因为上述遍历，只遍历到了最后一个单词的前面空格
        return new String(chars);
    }

    private static void reverse(char[] chars, int low, int high) {
        while (low < high) {
            char temp = chars[low];
            chars[low] = chars[high];
            chars[high] = temp;
            low++;
            high--;
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
//        System.out.println(ReverseSentence(str));
        System.out.println(ReverseSentence2(str));
    }
}
