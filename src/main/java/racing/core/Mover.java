package racing.core;

public class Mover {

    private static final int FORWARD_DECIDER = 4;

    public void decideMove(Car car, int randomNum) {
        if (isForward(randomNum)) {
            car.stepAhead();
        }
    }

    private boolean isForward(int num) {
        return num >= FORWARD_DECIDER;
    }

}
