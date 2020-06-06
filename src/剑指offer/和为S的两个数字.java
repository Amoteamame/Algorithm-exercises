package 剑指offer;

import java.util.ArrayList;

/**
 * Created by htFly on 2020/6/2.
 */
public class 和为S的两个数字 {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if (array == null || array.length == 0)
            return res;
        int low = 0, high = array.length - 1;
        while (low < high) {
            int curSum = array[low] + array[high];
            if (curSum == sum) {
                res.add(array[low]);
                res.add(array[high]);
                return res;
            } else if (curSum > sum) {
                high--;
            } else {
                low++;
            }
        }
        return res;
    }
}
