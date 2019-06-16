package camp.nextstep.edu.racingcar.view.dto;

import camp.nextstep.edu.racingcar.domain.CarNames;

import java.util.Objects;

public class GameRequest {
    private final CarNames carNames;
    private final int numberOfRounds;

    private GameRequest(CarNames carNames, int numberOfRounds) {
        this.carNames = carNames;
        this.numberOfRounds = numberOfRounds;
    }

    public static GameRequest of(CarNames carNames, int numberOfRounds) {
        return new GameRequest(carNames, numberOfRounds);
    }

    public CarNames getCarNames() {
        return carNames;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    @Override
    public String toString() {
        return "GameRequest{" +
                "carNames=" + carNames +
                ", numberOfRounds=" + numberOfRounds +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameRequest that = (GameRequest) o;
        return numberOfRounds == that.numberOfRounds &&
                carNames.equals(that.carNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carNames, numberOfRounds);
    }
}
