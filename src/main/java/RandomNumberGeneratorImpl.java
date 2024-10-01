import java.util.Random;

public class RandomNumberGeneratorImpl implements RandomNumberGenerator {
    public static int getInt() {
        Random random = new Random();
        return random.nextInt(10);
    }

    @Override
    public int generate() {
        return getInt();
    }
}
