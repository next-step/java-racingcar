package racingcar.domain;

public class RacingCar {
    private final String name;
    private final int position;

    public RacingCar(final String name, final int position) {
        this.name = name;
        this.position = position;
    }

    public RacingCar move(final MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            return new RacingCar(this.name, this.position + 1);
        }
        return this;
    }

    public boolean isInPosition(final int position) {
        return this.position == position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
