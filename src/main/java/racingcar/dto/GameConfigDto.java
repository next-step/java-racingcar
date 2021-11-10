package racingcar.dto;

import racingcar.utils.IntegerUtils;

public class GameConfigDto {

    private final int numberOfCars;
    private final int maxOfRound;

    public GameConfigDto(int maxOfCars, int maxOfRound) {
        this.numberOfCars = IntegerUtils.isPositiveNumber(maxOfCars);
        this.maxOfRound = IntegerUtils.isPositiveNumber(maxOfRound);
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public int getMaxOfRound() {
        return maxOfRound;
    }

}
