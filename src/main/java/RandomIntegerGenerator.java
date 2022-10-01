import java.util.Random;

public class RandomIntegerGenerator implements IntegerGenerator {

    private Random random = new Random();

    @Override
    public int getValue() {
        return random.nextInt(10);
    }
}
