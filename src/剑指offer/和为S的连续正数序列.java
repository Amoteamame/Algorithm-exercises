package 剑指offer;

import java.util.ArrayList;

/**
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class 和为S的连续正数序列 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int low = 1, high = 2;
        while (high > low) {

            int curSum = (low + high) * (high - low + 1) / 2;
            if (curSum == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = low; i <=high ; i++) {
                    list.add(i);
                }
                res.add(list);
                low++;
            } else if (curSum < sum) {
                high++;
            }else {
                low++;
            }


        }
        return res;
    }
}
