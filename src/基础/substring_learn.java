package 基础;

/**
 * Created by htFly on 2020/7/1.
 */
public class substring_learn {
    public static void main(String[] args) {
        String word= "hot";
        int L = word.length();
        for (int i = 0; i < L; i++) {
            String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
            System.out.println(newWord);
        }

    }
}
