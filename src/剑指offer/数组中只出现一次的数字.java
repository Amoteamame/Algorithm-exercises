package 剑指offer;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class 数组中只出现一次的数字 {
    public void FindNumsAppearOnce(int[] array, int[] num1, int[] num2)    {
        int len = array.length;
        if (len == 0) {
            num1[0] = array[0];
            num2[0] = array[0];
        }
        int bitResult = 0;
        for (int i = 0; i < len; i++) bitResult ^= array[i];
        int index = findFirst1(bitResult);
        for (int i = 0; i < len; i++) {
            //根据bitResult，分成两组
            if (isBit1(array[i], index)) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }

    // 拿到两个不同数字异或第一个1的位置
    private int findFirst1(int bitResult) {
        int index =0 ;
        while (((bitResult & 1) == 0) && index < 32) {
            bitResult >>=1;
            index++;
        }
        return index;
    }

    private boolean isBit1(int target, int index) {
        return ((target >> index) & 1) == 1;
    }
}
