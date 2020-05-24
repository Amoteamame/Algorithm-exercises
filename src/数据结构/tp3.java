package 数据结构;

import java.util.Scanner;

/**
 * Created by htFly on 2020/4/26.
 */
public class tp3 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
        }

        getRe(a,b);

    }

    private static void getRe(int[] a, int[] b) {


    }
}
