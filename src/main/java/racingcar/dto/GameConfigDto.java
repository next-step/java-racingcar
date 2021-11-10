package racingcar.dto;

import static racingcar.utils.IntegerUtils.*;


public class GameConfigDto {

    private final int numberOfCars;
    private final int maxOfRound;

    public GameConfigDto(int maxOfCars, int maxOfRound) {
        this.numberOfCars = isPositiveNumber(maxOfCars);
        this.maxOfRound = isPositiveNumber(maxOfRound);
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public int getMaxOfRound() {
        return maxOfRound;
    }

}
