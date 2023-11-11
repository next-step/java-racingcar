package step4.model;

public class MyRandomValueGenerator implements RandomValueGenerator {

    private static final int MAX_RACE_RANDOM_VALUE = 9;

    @Override
    public int generateRandomValue() {
        return (int) (Math.random() * (MAX_RACE_RANDOM_VALUE + 1));
    }
}
