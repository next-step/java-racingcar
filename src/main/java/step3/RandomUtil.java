package step3;

import java.util.Random;

public class RandomUtil {
    private static final Random random = new Random();

    public static int generateRandomNumber(int range){
        int temp = random.nextInt(range);
        System.out.println(temp);
        return temp;
    }
}
