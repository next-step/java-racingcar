package step3;
import java.util.Random;

public class RandomNumberGenerator {
    public static final int RANDOM_NUMBER_STANDARD = 10;

    public static int randomNumber() {
        Random random = new Random();
        return random.nextInt(RANDOM_NUMBER_STANDARD);
    }

}
