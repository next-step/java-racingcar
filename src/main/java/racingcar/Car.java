package racingcar;


public class Car {
    private static final int MOVE_MIN_NUM = 4;

    private int position;

    public Car(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void move(int num) {
        if (num >= MOVE_MIN_NUM) {
            position++;
        }
    }
}
