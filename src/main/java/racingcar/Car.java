package racingcar;

public class Car {

    private int position = 0;

    public void move() {
        position++;
    }

    public int position() {
        return position;
    }

    public void moveIfPossible(int number) {
        if (number >= 4) {
            move();
        }
    }
}
