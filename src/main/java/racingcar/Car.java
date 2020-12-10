package racingcar;

public class Car {
    private static final int INITIAL_LOCATION = 1;
    private static final int MOVE_CONDITION = 4;
    private static final int MOVE = 1;

    private int location = INITIAL_LOCATION;

    private final RandomGenerator generator = new RandomGenerator();

    public int getLocation() {
        return this.location;
    }

    public void move() {
        if(generator.getRandom() >= MOVE_CONDITION) {
            this.location += MOVE;
        }
    }
}
