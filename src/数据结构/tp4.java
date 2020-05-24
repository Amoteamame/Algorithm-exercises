package 数据结构;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by htFly on 2020/4/26.
 */
public class tp4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] arrStr = new String[n];
        for (int i = 0; i < n; i++) {
            String str = in.nextLine();
            arrStr[i] = str;
        }
        calc(arrStr,n);

    }

    private static void calc(String[] str, int n) {
        que q = null;
        for (int i = 0; i < n; i++) {
            if (str.equals("peek")) {
                System.out.println(q.peek());
            }else if(str.equals("poll")){
                q.poll();
            }else{
                String[] subStr = str[i].split(" ");
                int num = Integer.valueOf(subStr[2]);
                q.add(num);
            }
        }


    }

     public class que{
         public Stack<Integer> stackpush;
         public Stack<Integer> stackpop;

         public void add(int num){
             stackpush.push(num);
         }

         public int poll(){
             if (stackpop.empty()) {
                 while(!stackpush.empty()){
                    stackpop.push(stackpush.pop());
                 }
             }

             return stackpop.pop();

         }

         public int peek(){
             if (stackpop.empty()) {
                 while(!stackpush.empty()){
                     stackpop.push(stackpush.pop());
                 }
             }

             return stackpop.peek();
         }
    }


}
