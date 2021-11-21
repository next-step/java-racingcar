package carracing;

public class Car {

    public static final int RANDOM_BOUND = 10;
    private static final int MAX_RANDOM = RANDOM_BOUND - 1;
    private static final int MIN_RANDOM = 0;
    private static final int MIN_FORWARD = 4;

    private int step = 0;

    public void stepForwardByRandomNumber(int random) {
        if (validateRandom(random)) {
            throw new IllegalArgumentException(
                    String.format("Random must great or equal %d and less or equale than %d", MIN_RANDOM, MAX_RANDOM));
        }

        if (random >= MIN_FORWARD) {
            step += 1;
        }
    }

    private boolean validateRandom(int random) {
        return random < MIN_RANDOM || MAX_RANDOM < random;
    }

    public int getStep() {
        return step;
    }
}
