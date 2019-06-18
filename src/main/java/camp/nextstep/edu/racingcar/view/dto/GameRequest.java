package camp.nextstep.edu.racingcar.view.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameRequest {
    private final List<String> carNames;
    private final int numberOfRounds;

    private GameRequest(List<String> carNames, int numberOfRounds) {
        this.carNames = new ArrayList<>(carNames);
        this.numberOfRounds = numberOfRounds;
    }

    public static GameRequest of(List<String> carNames, int numberOfRounds) {
        return new GameRequest(carNames, numberOfRounds);
    }

    public List<String> getCarNames() {
        return new ArrayList<>(carNames);
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
