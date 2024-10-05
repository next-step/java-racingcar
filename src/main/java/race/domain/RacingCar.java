package race.domain;

public class RacingCar {
    private static final int DEFAULT_STATE = 0;
    private static final int MINIMUM_TO_GO_FORWARD = 4;
    private static final String CAR_STATE_MARKER = "-";
    public static final String CAR_NAME_POSTFIX = " : ";

    private int state = 0;
    private final String name;

    public RacingCar(String name) {
        this(name, DEFAULT_STATE);
    }

    public RacingCar(String name, int state) {
        this.name = name;
        this.state = state;
    }

    public int state() {
        return this.state;
    }

    public String name() {
        return this.name;
    }

    public String makeCarStateMessage() {
        StringBuilder message = new StringBuilder(name + CAR_NAME_POSTFIX);

        String carStateMarkers = CAR_STATE_MARKER.repeat(state);
        message.append(carStateMarkers);

        return message.toString();
    }

    public void moveCarForwardIfCanGo(int generatedRandom) {
        boolean carCanGo = canGo(generatedRandom);
        if (carCanGo) {
            moveForward();
        }
    }

    public int max(int maxState) {
        if (state > maxState) {
            return state;
        }
        return maxState;
    }

    private boolean canGo(int number) {
        return number >= MINIMUM_TO_GO_FORWARD;
    }

    private void moveForward() {
        state++;
    }

    public boolean isStateEqualWith(int state) {
        return this.state == state;
    }
}
