package racingcar.domain.Car;

import java.util.Objects;

public class Car {
    private static final int INITIAL_SCORE = 0;
    private static final int MIN_MOVE_NUMBER = 4;
    private final Name name;
    private final Score score;

    public Car(final String value) {
        this(new Name(value), new Score(INITIAL_SCORE));
    }

    public Car(final Name name, final Score score) {
        this.name = name;
        this.score = score;
    }

    public Car move(final int number) {
        if (number < MIN_MOVE_NUMBER) {
            return this;
        }
        return new Car(name, score.increase());
    }

    public boolean isSameScore(final int score) {
        return this.score.isSameScore(score);
    }

    public String getName() {
        return name.get();
    }

    public int getScore() {
        return score.get();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(score, car.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }
}
