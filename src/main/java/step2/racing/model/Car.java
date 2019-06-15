package step2.racing.model;

public class Car {

    private int position;

    /**
     * 차량번호
     */
    private final int number;

    public static final int DEFAULT_POSITION = 1;
    private static final int MOVE_VALUE = 4;

    private Car(int number) {

        this.position = DEFAULT_POSITION;
        this.number = number;
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

    public int getNumber() {

        return number;
    }
}
