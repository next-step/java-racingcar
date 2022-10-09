package racing.core;

public class Mover {

    private static final int STEP_COUNT = 1;
    private static final int FORWARD_DECIDER = 4;

    public Mover() {
    }

    public void decideMove(Car car, int randomNum) {
        if (isForward(randomNum)) {
            car.stepAhead(STEP_COUNT);
        }
    }

    private boolean isForward(int num) {
        return num >= FORWARD_DECIDER;
    }

}
