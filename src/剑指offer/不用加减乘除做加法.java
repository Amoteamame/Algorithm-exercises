package 剑指offer;

/**
 * Created by htFly on 2020/5/27.
 */
public class 不用加减乘除做加法 {
    public static int Add(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1 ^ num2; //计算直接相加没有进位的值
            num2 = (num1 & num2) << 1; //计算进位值
            num1 = temp;
        }
        return num1;
    }

    public static void main(String[] args) {
        int num1 = 1, num2 = 3;
        System.out.println(Add(num1, num2));
    }
}
