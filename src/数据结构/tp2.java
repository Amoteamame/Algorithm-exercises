package 数据结构;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by htFly on 2020/4/26.
 */
public class tp2 {
    private static double process() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] array1 = new int[n][2];
        int[][] array2 = new int[n][2];

        for (int i = 0; i < n; i++) {
            array1[i][0] = in.nextInt();
            array1[i][1] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            array2[i][0] = in.nextInt();
            array2[i][1] = in.nextInt();
        }

        return getRe(array1,array2,n);
    }


    private static double getRe(int[][] array1, int[][] array2,int n) {
        double sum = 0;
        double pre = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum = Math.sqrt((array1[i][0]-array2[j][0])*(array1[i][0]-array2[j][0])+
                        (array1[i][1]-array2[j][1])*(array1[i][1]-array2[j][1]));
                if (sum == 0) {
                    return Math.round(sum*1000)/1000.0;
                }else if (pre == 0){
                    pre = sum;
                } else if (sum < pre) {
                    pre = sum;
                }

            }
            if (sum == 0) {
                break;
            }
        }
        pre = Math.round(pre*1000)/1000.0;
        return pre;


    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double [] array =new double[n];
        for (int i = 0; i < n; i++) {
            array[i] = process();
        }

        for (int i = 0; i < n; i++) {
            if (array[i] == 0) {
                DecimalFormat df = new DecimalFormat("#0.000");
                System.out.println(df.format(array[i]));
            }else  {

            System.out.println(array[i]);
            }
        }
    }


}
