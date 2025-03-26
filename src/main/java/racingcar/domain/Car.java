package racingcar.domain;

public class Car {

    private static final int INITIAL_POSITION = 0;
    private int position;

    public Car() {
        position = INITIAL_POSITION;
    }

    public void move(boolean canMove) {
        if (canMove) {
            position++;
        }
    }
    
}
