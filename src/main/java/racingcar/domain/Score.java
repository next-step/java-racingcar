package racingcar.domain;

import java.util.Objects;

public class Score {

    private final Name name;

    private final Position position;

    public Score(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public boolean isWinner(Position maxPosition) {
        return position.equals(maxPosition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score = (Score) o;
        return Objects.equals(name, score.name) && Objects.equals(position, score.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    public static Score of(RacingCar racingCar) {
        return new Score(racingCar.getName(), racingCar.getPosition());
    }
}
