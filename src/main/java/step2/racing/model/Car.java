package step2.racing.model;

public class Car {

    static final int DEFAULT_POSITION = 1;
    static final int MOVE_THRESHOLD = 4;

    /**
     * 차량번호
     */
    private final int uniqueNumber;
    private int position;

    private Car(int uniqueNumber) {

        this.position = DEFAULT_POSITION;
        this.uniqueNumber = uniqueNumber;
    }

    public static Car of(int uniqueNumber) {

        return new Car(uniqueNumber);
    }

    public void race(int value) {

        if (isMoveValue(value)) {
            position++;
        }
    }

    private boolean isMoveValue(int value) {

        return value >= MOVE_THRESHOLD;
    }

    public int getPosition() {

        return position;
    }

    public int getUniqueNumber() {

        return uniqueNumber;
    }
}
