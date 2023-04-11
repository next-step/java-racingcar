package racingcar;

public class Car {

    private int position;

    public void move(int number) {
        if (movable(number)) {
            position++;
        }
    }

    private boolean movable(int number) {
        return number >= 4;
    }

    public int getPosition() {
        return position;
    }
}
