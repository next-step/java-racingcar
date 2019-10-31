package step1.racing.factories;

import step1.racing.IntegerRandomListGenerator;
import step1.racing.RandomListGenerator;

public class RandomListGeneratorFactory {
    public static RandomListGenerator getRandomListGenerator(Class type) {
        if (type == Integer.class) {
            return IntegerRandomListGenerator.getInstance();
        }

        throw new IllegalArgumentException("Can not resolve type, type=" + type.getSimpleName());
    }
}
