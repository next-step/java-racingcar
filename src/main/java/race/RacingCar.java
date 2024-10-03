package race;

public class RacingCar {
    private static final int DEFAULT_STATE = 0;
    private static final int MINIMUM_TO_GO_FORWARD = 4;

    private int state = 0;

    public RacingCar() {
        this.state = DEFAULT_STATE;
    }

    public int state() {
        return this.state;
    }

    public void moveCarForwardIfCanGo(int generatedRandom) {
        boolean carCanGo = canGo(generatedRandom);
        if (carCanGo) {
            moveForward();
        }
    }

    private boolean canGo(int number) {
        return number >= MINIMUM_TO_GO_FORWARD;
    }

    private void moveForward() {
        state++;
    }
}
