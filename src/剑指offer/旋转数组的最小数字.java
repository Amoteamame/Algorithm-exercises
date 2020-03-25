package 剑指offer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 链接：https://www.nowcoder.com/questionTerminal/9f3231a991af4f55b95579b44b7a01ba?f=discussion
 *         来源：牛客网
 *          遍历整个数组，找出其中最小的数。这样肯定拿不到offer
 */
public class 旋转数组的最小数字 {
    // 原来的数组是非递减的，也就是说后面的数都比前面的大，但是旋转数组，旋转后的第一个数肯定比旋转数组的末尾小，所以找出第一个这个数
    public int minNumberInRotateArray1(int [] array) {
        if (array.length == 0)
            return 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1])
                return array[i + 1];
        }
        return array[0];
    }

    // 二分,这个二分针对 {1,0,1,1,1}会无限循环
    public static int minNumberInRotateArray2(int[] array) {
        if (array.length == 0)
            return 0;
        int left = 0;
        int right = array.length - 1;
        int middle = -1;
        while (array[left]>=array[right]) {
            if(right-left==1){
                middle = right;
                break;
            }
            middle = left + (right - left) / 2;
            if (array[middle] >= array[left]) {
                left = middle;
            }
            if (array[middle] <= array[right]) {
                right = middle;
            }
        }
        return array[middle];
    }

    //https://blog.nowcoder.net/n/dcb0f2e6ffd44e1895b7a5297e362778

  /*  分析：二分查找变种，没有具体的值用来比较。那么用中间值和高低位进行比较，看处于递增还是递减序列，进行操作缩小范围。

    处于递增：low上移

    处于递减：high下移（如果是high-1，则可能会错过最小值，因为找的就是最小值）

    其余情况：low++缩小范围*/
    static int minNumberInRotateArray(int[] array) {
        if(array.length == 0)
            return 0;

        int low = 0;
        int high = array.length - 1;
        int mid = 0;

        while(low < high){
            // 子数组是非递减的数组，10111
            if (array[low] < array[high])
                return array[low];
            mid = low + (high - low) / 2;
            if(array[mid] > array[low])
                low = mid + 1;
            else if(array[mid] < array[high])
                high = mid;
            else low++;
        }
        return array[low];
    }

    public static void main(String[] args) {
        int [] array = {1,0,1,1,1};
        System.out.println(minNumberInRotateArray(array));;
    }
}
