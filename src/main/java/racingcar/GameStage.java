package racingcar;

import static racingcar.utils.IntegerUtils.*;

import racingcar.dto.GameConfigDto;

public class GameStage {

    private final int maxOfRound;
    private final Car[] cars;

    private GameStage(int maxOfRound, int numberOfCars) {
        this.maxOfRound = isPositiveNumber(maxOfRound);
        this.cars = new Car[numberOfCars];
    }

    public static GameStage init(GameConfigDto config) {
        return new GameStage(config.getMaxOfRound(), config.getNumberOfCars());
    }
}
