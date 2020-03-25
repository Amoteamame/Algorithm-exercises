package 数据结构;

import java.util.Arrays;

/**
 * https://blog.csdn.net/nrsc272420199/article/details/82587933
 * https://www.cnblogs.com/BaoZiY/p/10931305.html
 * <p>
 * 基于分治的思想，是冒泡排序的改进型。首先在数组中选择一个基准点（该基准点的选取可能影响快速排序的效率，后面讲解选取的方法），
 * 然后分别从数组的两端扫描数组，设两个指示标志（low指向起始位置，high指向末尾)，首先从后半部分开始，如果发现有元素比该基准点的值小，
 * 就交换low和high位置的值，然后从前半部分开始扫秒，发现有元素大于基准点的值，就交换low和high位置的值，如此往复循环，直到low>=high,然后把基准点的值放到high这个位置。
 * 一次排序就完成了。以后采用递归的方式分别对前半部分和后半部分排序，当前半部分和后半部分均有序时该数组就自然有序了。
 *
 *
 * 快速排序的时间主要耗费在划分操作上，对长度为k的区间进行划分，共需k-1次关键字的比较；
 * 最坏情况是每次划分选取的基准都是当前无序区中关键字最小(或最大)的记录，划分的结果是基准左边的子区间为空(或右边的子区间为空)，
 * 而划分所得的另一个非空的子区间中记录数目，仅仅比划分前的无序区中记录个数减少一个。时间复杂度为O(n*n)；
 * 在最好情况下，每次划分所取的基准都是当前无序区的"中值"记录，划分的结果是基准的左、右两个无序子区间的长度大致相等。总的关键字比较次数：O(nlogn)；
 * 尽管快速排序的最坏时间为O(n*n)，但就平均性能而言，它是基于关键字比较的内部排序算法中速度最快者，快速排序亦因此而得名。它的平均时间复杂度为O(nlogn)。
 */
public class QuickSort {
    public static void main(String[] args) {
        final int MAX = 15;
        int[] nums = new int[MAX];
        for (int i = 0; i < MAX; i++) {
            nums[i] =(int)(Math.random()*10 + 5);
        }
        System.out.println("排序之前的数组为...............");
        System.out.println(Arrays.toString(nums));
        System.out.println("排序之后的数组为...............");

        QuickSort sort = new QuickSort();
        sort.quikSort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    private void quikSort(int[] nums, int low, int high) {
        if (low < high) {
            int middle = getMiddle(nums, low, high);
            // 对左子序列排序
            quikSort(nums,low,middle-1);
            // 对右子序列排序
            quikSort(nums,middle+1, high);
        }
    }

    private int getMiddle(int[] nums, int low, int high) {
        //当前数组的第一个元素作为中轴（基准）
        int temp = nums[low];
        while (low < high) {
            //这里temp <= nums[high]中等号的情况相当于数组中出现了两个相等的数字，循环比较依然能够继续
            while (low < high && temp <= nums[high]) {
                high--;
            }
            nums[low] = nums[high];
            while (low < high && temp >= nums[low]) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = temp;
        return low;
    }
}
