package racingcar;



public class Car {
    private static final int STEP_HURDLE = 4;

    private int position = 0;

    public void moveForward(int value) {
        if (value < STEP_HURDLE) {
            return;
        }
        position += 1;
    }

    public int position() {
        return position;
    }

}
