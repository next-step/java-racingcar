package racing_refactoring.domain;

import java.util.Objects;

public class RacingCar {
    private static final int START_POSITION = 0;

    private final RacingName name;
    private final RacingPosition position;

    RacingCar(String name) {
        this(name, START_POSITION);
    }

    RacingCar(String name, int position) {
        this(name, new RacingPosition(position));
    }

    RacingCar(String name, RacingPosition position) {
        this(new RacingName(name.trim()), position);
    }

    private RacingCar(RacingName name, RacingPosition position) {
        this.name = name;
        this.position = position;
    }

    RacingCar move() {
        MovingStrategy movingStrategy = new RandomMovingStrategy();
        return new RacingCar(this.name, position.move(movingStrategy));
    }

    boolean isWinner(int maxPosition) {
        return position.isMaxPosition(maxPosition);
    }

    int maxPosition(int maxPosition) {
        return position.maxPosition(maxPosition);
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return Objects.equals(name, racingCar.name) &&
                Objects.equals(position, racingCar.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return "RacingCar{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}
