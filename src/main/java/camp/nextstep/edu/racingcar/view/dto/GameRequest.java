package camp.nextstep.edu.racingcar.view.dto;

import java.util.Objects;

public class GameRequest {
    private final int numberOfCars;
    private final int numberOfRounds;

    private GameRequest(int numberOfCars, int numberOfRounds) {
        this.numberOfCars = numberOfCars;
        this.numberOfRounds = numberOfRounds;
    }

    public static GameRequest of(int numberOfCars, int numberOfRounds) {
        return new GameRequest(numberOfCars, numberOfRounds);
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    @Override
    public String toString() {
        return "GameRequest{" +
                "numberOfCars=" + numberOfCars +
                ", numberOfRounds=" + numberOfRounds +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameRequest that = (GameRequest) o;
        return numberOfCars == that.numberOfCars &&
                numberOfRounds == that.numberOfRounds;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfCars, numberOfRounds);
    }
}
