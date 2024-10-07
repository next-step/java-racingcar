package race.domain;

public class RacingCar {
    private static final int MINIMUM_TO_GO_FORWARD = 4;

    private final CarState state;
    private final String name;

    public RacingCar(String name) {
        this(name, new CarState());
    }

    public RacingCar(String name, int state) {
        this.name = name;
        this.state = new CarState(state);
    }

    public RacingCar(String name, CarState state) {
        this.name = name;
        this.state = state;
    }

    public String name() {
        return this.name;
    }

    public String makeCarStateMessage() {
        String carStateMarkers = state.makeCarStateMarkers();
        return String.format("%s : %s", name, carStateMarkers);
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

    public int max(int maxState) {
        return state.max(maxState);
    }

    private void moveForward() {
        state.moveForward();
    }

    public boolean isStateEqualWith(int state) {
        return this.state.isEqualWith(state);
    }
}
