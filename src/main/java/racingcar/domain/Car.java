package racingcar.domain;

public class Car {

    private int position;
    private final int CAR_MOVE_CRITERIA = 4;
    private final RandomGenerator randomGenerator;

    public Car() {
        this.position = 0;
        randomGenerator = new RandomGenerator();
    }

    public boolean isOver(int randomValue) {
        return CAR_MOVE_CRITERIA <= randomValue;
    }

    public void move() {
        int randomValue = randomGenerator.getValue();
        if (isOver(randomValue)) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
