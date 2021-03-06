package 剑指offer;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class 替换空格 {

    public static String replaceSpace(StringBuffer str) {
        StringBuffer c_str = new StringBuffer("");
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(str.charAt(i) == ' ') {
                c_str.append("%20");
            }
            else
                c_str.append(c);
        }

        return c_str.toString();
    }

    public static String replaceSpace2(StringBuffer str) {
        char[] cs = str.toString().toCharArray();
        int space = 0; // 空格数量
        int len = cs.length;
        for (int i = 0; i < len; i++) {
            if (cs[i] == ' ') {
                space++;
            }
        }
        int new_len = len + 2 * space;
        char[] new_cs = new char[new_len];
        int index = new_len-1;//记录新字符串的下标位置
        for (int i = len-1; i >=0; i++) {
            if (cs[i] == ' ') {
                new_cs[index--] = '0';
                new_cs[index--] = '2';
                new_cs[index--] = '%';
            } else {
                new_cs[index--] = cs[i];
            }
        }
        return String.valueOf(new_cs);
    }
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("We Are Happy");
       /* System.out.println(replaceSpace(sb));
        System.out.println("%20".length());*/


        System.out.println(replaceSpace2(sb));
    }
}
