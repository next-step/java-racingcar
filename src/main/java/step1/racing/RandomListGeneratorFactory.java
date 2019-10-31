package step1.racing;

public class RandomListGeneratorFactory {
    public static RandomListGenerator getRandomListGenerator(Class type) {
        if (type == Integer.class) {
            return IntegerRandomListGenerator.getInstance();
        }

        throw new IllegalArgumentException("Can not resolve type, type=" + type.getSimpleName());
    }
}
