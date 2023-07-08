package racingcar.domain;

import java.util.Objects;

public class Car {
    private final int MIN_MOVE_NUMBER = 4;
    private final int INITIAL_SCORE = 0;
    private final Name name;
    private final Score score;

    public Car(String value) {
        this.score = new Score(INITIAL_SCORE);
        this.name = new Name(value);
    }

    private Car(Name name, Score score) {
        this.name = name;
        this.score = score;
    }

    public Car move(int number) {
        if (number < MIN_MOVE_NUMBER) {
            return this;
        }
        return new Car(name, score.increase());
    }

    public boolean isSameScore(int maxScore) {
        return score.isSameScore(maxScore);
    }

    public Name getName() {
        return name;
    }

    public Score getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return score == car.score && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }
}
