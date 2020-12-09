package racingcar;

public class Car {
    private final int INITIAL_LOCATION = 1;
    private int location = INITIAL_LOCATION;

    private final int MOVE_CONDITION = 4;
    private final int MOVE = 1;

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
