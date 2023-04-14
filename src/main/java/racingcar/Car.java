package racingcar;

public class Car {

    private static final int MOVED_NUMBER = 4;

    private final RandomNumberGenerator randomNumberGenerator;
    private int position = 0;

    public Car(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void racing() {
        if (isMove()) {
            position++;
        }
    }

    private boolean isMove() {
        return randomNumberGenerator.generate() >= MOVED_NUMBER;
    }

    public int getPosition() {
        return position;
    }
}
