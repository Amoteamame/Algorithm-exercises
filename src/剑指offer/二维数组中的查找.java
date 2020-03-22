package 剑指offer;

// 在一个二维数组中（每个一维数组的长度相同），
// 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
// 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

public class 二维数组中的查找 {
    // 暴力解
    public static boolean Find(int target, int[][] array) {
        for (int[] item1 : array) {
            for (int item2 : item1) {
                if (item2 == target) {
                    return true;
                }
            }
        }
        return false;
    }
    // 二分法,遍历每一行时用二分法,时间复杂度是nlogn
    public static boolean Find2(int target, int[][] array){
        for (int[] item1 : array) {
            int high = item1.length-1;
            int low = 0;
            while (high >=low){
                int mid = (high +low) /2;
                if(item1[mid] < target)
                    low++;
                else if(item1[mid] > target)
                    high--;
                else
                    return true;
            }

        }

        return false;
    }



    // 二维数组从左到右增序，从上到下增序；所以以右上角点为例，若target比这个数小，一定在该数的左边；若target比这个点大，则一定在下边
    public static boolean Find3(int target, int[][] array) {
        int left = array[0].length-1;
        int down = 0;
        while(left>=0 && down <=array.length-1){
            int index = array[down][left];
            if(index >target)
                left--;
            else if(index <target)
                down++;
            else
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] array = { { 1, 2, 3 }, { 2, 3, 4 }, { 3, 4, 5 } };

        int a = 3; // 在数组
        int b = 6; // 不在数组
//        System.out.println(Find(a, array));
//        Find(b, array);
        /*System.out.println(Find2(a, array));
        System.out.println(Find2(b, array));*/
        System.out.println(Find3(a, array));
        System.out.println(Find3(b, array));
    }
}