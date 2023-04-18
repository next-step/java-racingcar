package step3;
import java.util.Random;

public class RandomNumberGenerator {
    public static int randomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

}
