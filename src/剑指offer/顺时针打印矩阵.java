package 剑指offer;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下
 * 4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class 顺时针打印矩阵 {
    // 采用旋转魔方思想，每次打印第一行，每打印一行，删除第一行，然后逆时针旋转一次
    public ArrayList<Integer> printMatrix(int[][] matrix){
        ArrayList<Integer> al = new ArrayList<>();
        int row = matrix.length;
        while (row != 0) {
            for (int i = 0; i < matrix[0].length; i++) {
                al.add(matrix[0][i]);
            }
            if (row == 1) {
                break;
            }
            matrix = turn(matrix); // 逆时针旋转一次
            row = matrix.length;
        }
        return al;
    }

    private int[][] turn(int[][] matrix) {
        int col = matrix[0].length;
        int row = matrix.length;
        int[][] newMatrix = new int[col][row - 1];
        for (int j = col - 1; j >=0; j--) {
            for (int i = 1; i < row; i++) {
                // i从第一行起
                newMatrix[col-1-j][i-1] = matrix[i][j];
            }
        }
        return newMatrix;
    }
}
