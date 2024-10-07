package race.domain;

public class CarState {
    private static final int DEFAULT_STATE = 0;
    private static final String CAR_STATE_MARKER = "-";

    private int state;

    public CarState() {
        state = DEFAULT_STATE;
    }

    public CarState(int state) {
        this.state = state;
    }

    public String makeCarStateMarkers() {
        return CAR_STATE_MARKER.repeat(state);
    }

    public int max(int maxState) {
        if (state > maxState) {
            return state;
        }
        return maxState;
    }

    public void moveForward() {
        state = state + 1;
    }

    public boolean isEqualWith(int state) {
        return this.state == state;
    }
}
