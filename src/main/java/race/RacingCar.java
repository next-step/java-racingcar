package race;

public class RacingCar {
    private static final int DEFAULT_STATE = 0;
    private static final int MINIMUM_TO_GO_FORWARD = 4;

    private int state = 0;
    private final String name;

    public RacingCar(String name) {
        this.state = DEFAULT_STATE;
        this.name = name;
    }

    public int state() {
        return this.state;
    }

    public String name() {
        return this.name;
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
