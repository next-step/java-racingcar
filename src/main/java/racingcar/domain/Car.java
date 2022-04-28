package racingcar.domain;

public class Car {

    private final CarName name;
    private final Position position;

    public Car(final String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = new CarName(name);
        this.position = new Position(position);
    }

    public void moveOrStop(RacingStrategy racingStrategy) {
        if (racingStrategy.checkCondition()) {
            position.move();
        }
    }

    public boolean isWinner(int max) {
        return position.equal(max);
    }

    public int getMaxPosition(int max) {
        return position.calMaxPosition(max);
    }

    public int getMovement() {
        return position.getMovement();
    }

    public String getName() {
        return name.getName();
    }

}
