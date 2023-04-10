package racingcar;

public class Car {

    private int position;

    public void push(int number) {
        if (movable(number)) {
            move();
        }
    }

    private boolean movable(int number) {
        return number >= 4;
    }

    private void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }
}
