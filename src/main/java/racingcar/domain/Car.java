package racingcar.domain;

public class Car {

    private static final int INIT_POSITION = 0;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MIN_NUMBER_FOR_START = 4;

    private final String name;
    private int position;

    public Car(String name) {
        checkCarName(name);
        this.name = name;
        this.position = INIT_POSITION;
    }

    private void checkCarName(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("차의 이름은 5글자가 넘으면 안됩니다.");
        }
    }

    public void raceOneTime(int condition) {
        if (condition >= MIN_NUMBER_FOR_START) {
            go();
        }
    }

    private void go() {
        this.position++;
    }

    public int comparePosition(int maximum) {
        return Math.max(maximum, position);
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
