package 剑指offer;

/**
 *
 */
public class 数组中重复的数字 {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers==null) return false;

        // 判断数组是否合法
        for (int i = 0; i < length; i++) {
            if (numbers[i] < 0 || numbers[i] > length - 1) {
                return false;
            }
        }
        int[] hash = new int[length];
        for (int i = 0; i < length; i++) {
            hash[numbers[i]]++;
        }
        for (int i = 0; i < length; i++) {
            if (hash[i] > 1) {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }
    public boolean duplicate2(int numbers[],int length,int [] duplication) {
        boolean[] k = new boolean[length];
        for (int i = 0; i < k.length; i++) {
            if (k[numbers[i]] == true) {
                duplication[0] = numbers[i];
                return true;
            }
            k[numbers[i]] = true;
        }
        return false;
    }

}
