package racingcar;

public class Car {
    private static final int MOVE_MIN_VALUE = 4;

    private int position = 0;

    public int getPosition() {
        return position;
    }

    public void moveCar(int randomValue) {
        if(randomValue >= MOVE_MIN_VALUE)
            this.position++;
    }
}