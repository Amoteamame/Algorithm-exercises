package 剑指offer;

import java.util.Arrays;

/**
 * Created by htFly on 2020/5/26.
 */
public class 扑克牌顺子 {
    public boolean isContinuous(int [] numbers) {
        if (numbers.length == 0) {
            return false;
        }
        int[]d = new int[14];
        d[0] = -5;
        int len = numbers.length;
        int max = -1;
        int min = 14;
        for(int i =0;i<len;i++){
            d[numbers[i]]++;
            if(numbers[i] == 0){
                continue;
            }
            if(d[numbers[i]]>1){
                return false;
            }
            if(numbers[i] >max){
                max = numbers[i];
            } if(numbers[i] <min){
                min = numbers[i];
            }

        }
        if(max -min<5){
            return true;
        }
        return false;
    }

    public boolean isContinuous2(int [] numbers) {
        if (numbers == null || numbers.length <= 4) {
            return false;
        }
        Arrays.sort(numbers); // 先排序
        int totalGap =0;
        int countZero = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                countZero++;
                continue;
            }
            //计算间隔
            if (i < numbers.length - 1) {
                int gap = numbers[i + 1] - numbers[i] - 1;// 1,3之间间隔一个2,所以要再减1
                if (gap < 0) {
                    return false;
                }
                totalGap += gap;
            }
        }
        if (totalGap > countZero) {
            return false;
        }
        return true;
    }
}
