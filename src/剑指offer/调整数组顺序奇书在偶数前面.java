package 剑指offer;

/**
 * Created by htFly on 2020/4/21.
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class 调整数组顺序奇书在偶数前面 {

    /*

    链接：https://www.nowcoder.com/questionTerminal/beb5aa231adc45b2a5dcc5b62c93f593?f=discussion
来源：牛客网

相对位置不变--->保持稳定性；奇数位于前面，偶数位于后面 --->存在判断，挪动元素位置；
这些都和内部排序算法相似，考虑到具有稳定性的排序算法不多，例如插入排序，归并排序等；这里采用插入排序的思想实现。
     */
    public static void reOrderArray(int [] array) {
        int len = array.length;
        int k = 0; //记录已经排序的奇数的个数
        for (int i = 0; i < len; i++) {
            if(array[i] % 2==1){
                int j = i;
                while(j>k){
                    int tmp = array[j];
                    array[j] = array[j - 1];
                    array[j-1] = tmp;
                    j--;
                }
                k++;
            }
        }


    }

    public static void main(String[] args) {
        int[] array = {3,1,2,5,7,8,9};

        reOrderArray(array);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

}
