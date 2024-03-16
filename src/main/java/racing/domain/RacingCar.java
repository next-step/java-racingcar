package racing.domain;

public class RacingCar {
    private static final int MOVE_BORDER_NUMBER = 4;

    private final CarName name;
    private Position position;

    public RacingCar(String name) {
        this(name, 0);
    }

    public RacingCar(String name, int position) {
        this(new CarName(name), new Position(position));
    }

    public RacingCar(CarName carName, Position position) {
        this.name = carName;
        this.position = position;
    }

    public String getName() {
        return name.value();
    }

    public int getPosition() {
        return position.value();
    }

    public void attemptToMove(int conditionNumber) {
        if (conditionNumber >= MOVE_BORDER_NUMBER) {
            move();
        }
    }

    public boolean isWinner(int highScore) {
        return this.position.equals(new Position(highScore));
    }

    private void move() {
        this.position = this.position.nextPosition();
    }
}
