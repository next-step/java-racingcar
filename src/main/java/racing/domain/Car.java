package racing.domain;

import java.util.Objects;

public class Car {

    public static final int DEFAULT_POSITION = 0;
    private final Position position;
    private final Name name;

    public Car(String name) {
        this(new Name(name), new Position(DEFAULT_POSITION));
    }

    public Car(String name, int initPosition) {
        this(new Name(name), new Position(initPosition));
    }

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }


    public Position getPosition() {
        return position;
    }

    public Name getName() {
        return name;
    }

    public Car race(int randomNumber) {
        if (randomNumber < 0 || randomNumber > 9) {
            throw new IllegalArgumentException("Wrong random number.");
        }
        if (randomNumber > 3) {
            return new Car(name, new Position(position.move()));
        }
        return new Car(name, new Position(position));
    }

    public int max(int maxPosition) {
        return position.max(maxPosition);

    }

    public boolean isWinner(int winnerPosition) {
        return position.isSame(winnerPosition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position.equals(car.position) && name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }
}
