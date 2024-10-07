package race.domain;

public class RacingCar {
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

    @Override
    public String toString() {
        String carStateMarkers = state.makeCarStateMarkers();
        return String.format("%s : %s", name, carStateMarkers);
    }

    public void move(GoCondition goCondition) {
        boolean carCanGo = goCondition.canGo();
        if (carCanGo) {
            moveForward();
        }
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
