package racingcar;

public class Car {

    private static final int THRESHOLD = 4;

    private int position;

    public Car() {
        position = 0;
    }

    public int getPosition() {
        return position;
    }

    public void stopOrMove(int randomNumber) {
        if (randomNumber >= THRESHOLD) {
            position++;
        }
    }

}
