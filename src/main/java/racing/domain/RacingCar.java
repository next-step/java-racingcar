package racing.domain;

public class RacingCar {
    private static final int MOVE_BORDER_NUMBER = 4;

    private final CarName name;
    private int position;

    public RacingCar(String name) {
        this.name = new CarName(name);
        this.position = 0;
    }

    public RacingCar(String name, int position) {
        this.name = new CarName(name);
        this.position = position;
    }

    public String getName() {
        return name.value();
    }

    public int getPosition() {
        return position;
    }

    public void attemptToMove(int conditionNumber) {
        if (conditionNumber >= MOVE_BORDER_NUMBER) {
            move();
        }
    }

    private void move() {
        this.position++;
    }
}
