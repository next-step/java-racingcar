package race;

import java.util.Random;

public class RandomValueGenerator implements IRandomValueGenerator {
    private RandomValueGenerator() {
    }

    @Override
    public int generateFromZeroTo(int exclusiveEnd) {
        return new Random().nextInt(exclusiveEnd);
    }

    public static RandomValueGenerator create() {
        return new RandomValueGenerator();
    }
}
