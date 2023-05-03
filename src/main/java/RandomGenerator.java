import java.util.Random;

public class RandomGenerator {

    public static int create() {
        return new Random().nextInt(10);
    }

}
