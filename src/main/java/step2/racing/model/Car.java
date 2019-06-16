package step2.racing.model;

public class Car {

    public static final int DEFAULT_POSITION = 1;
    private static final int MOVE_VALUE = 4;

    /**
     * 차량번호
     */
    private final int uniqueNumber;
    private int position;

    private Car(int uniqueNumber) {

        this.position = DEFAULT_POSITION;
        this.uniqueNumber = uniqueNumber;
    }

    public static Car of(int number) {

        return new Car(number);
    }

    public void race(int randomInt) {

        if (isMove(randomInt)) {
            position++;
        }
    }

    private boolean isMove(int randomInt) {

        return randomInt >= MOVE_VALUE;
    }

    public int getPosition() {

        return position;
    }

    public int getUniqueNumber() {

        return uniqueNumber;
    }
}
