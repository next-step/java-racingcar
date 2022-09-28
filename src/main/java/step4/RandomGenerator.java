package step4;

public class RandomGenerator {

    private static final int MOVABLE_BOUNDARY = 3;
    private static int random;

    public RandomGenerator() {
        this.random = new java.util.Random().nextInt(10);
    }

    boolean isRandomGreaterThanThree() {
        return this.random > MOVABLE_BOUNDARY;
    }
}
