package 剑指offer;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 */
public class 斐波那契数列 {
    public int Fibonacci1(int n) {
        int preNum =1;
        int prePreNum=0;
        int result =0;
        if (n==0)
            return 0;
        if(n==1)
            return 1;
        for (int i=2;i<=n;i++){
            result=preNum+prePreNum;
            prePreNum=preNum;
            preNum=result;
        }
        return result;
    }


   /* 链接：https://www.nowcoder.com/questionTerminal/c6c7742f5ba7442aada113136ddea0c3?f=discussion
    来源：牛客网

    给一个尾递归的解答：不是不能用递归，递归本质上是栈，可能导致栈溢出，只要避免溢出就可以了。大家不要被惯性思维所限制啊，熟悉的题目只想到了熟悉的解答，那样还是书呆子！
    */

    public int Fibonacci(int n) {
        return Fibonacci(n,0,1);
    }


    private static int Fibonacci(int n,int acc1,int acc2){
        if(n==0) return 0;
        if(n==1) return acc2;
        else     return Fibonacci(n - 1, acc2, acc1 + acc2);

    }
}
