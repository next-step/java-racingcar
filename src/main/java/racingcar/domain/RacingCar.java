package racingcar.domain;

import racingcar.domain.moving.Position;

import java.util.Objects;

public class RacingCar {
    private String name;
    private Position position;

    private RacingCar(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    public static RacingCar of(String name, Position position) {
        return new RacingCar(name, position);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position.get();
    }

    public boolean isWinner(int winnerPosition) {
        return position.isSamePosition(winnerPosition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return Objects.equals(position, racingCar.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}