import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Tatiana {
    private static HashMap<Integer, String> n = new HashMap<>();
    public static void main(String[] args){
        n.put(1, "+");
        n.put(2, "-");
        int a = 7;
        int b = 6;
        String result = a + n.get(1)+b;
//        System.out.println(result);
        Random random = new Random();
        int m =20;

        System.out.println(random.nextInt(10) +m);

    }
}
