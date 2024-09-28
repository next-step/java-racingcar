import java.util.Random;

public class RandomUtil {
    public static int getInt() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
