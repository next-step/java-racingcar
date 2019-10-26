package racingcar;

public class Car {

    private static final int MOVE_CONDITION_NUMBER = 4;
    private int location;

    public Car() {
        this.location = 0;
    }

    public Car(int location) {
        this.location = location;
    }

    void move(int number) {

        if (isPossibleMove(number)) {
            this.location++;
        }
    }

    private boolean isPossibleMove(int number) {
        return number >= MOVE_CONDITION_NUMBER;
    }

    int getLocation() {
        return location;
    }
}
