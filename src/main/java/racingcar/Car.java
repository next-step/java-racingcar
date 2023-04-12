package racingcar;

public class Car {

    private final static int MOVE_CRITERIA = 4;

    private int location;

    public Car() {
        location = 0;
    }

    public int location() {
        return this.location;
    }

    public void move(int inputValue) {
        if (inputValue >= MOVE_CRITERIA) {
            location++;
        }
    }
}
