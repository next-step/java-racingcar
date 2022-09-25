package racingcar;

import java.util.Objects;

public class RacingGame {
    int carQuantity;
    int movementCount;

    private RacingGame(int carQuantity, int movementCount) {
        this.carQuantity = carQuantity;
        this.movementCount = movementCount;
    }

    public static RacingGame ready(Input input) {
        return new RacingGame(input.getCarQuantity(), input.getMovementCount());
    }

    public static RacingGame ready(int carQuantity, int movementCount) {
        return new RacingGame(carQuantity, movementCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingGame that = (RacingGame) o;
        return carQuantity == that.carQuantity && movementCount == that.movementCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(carQuantity, movementCount);
    }
}