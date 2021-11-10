package racingcar;

import racingcar.dto.GameConfigDto;
import racingcar.utils.IntegerUtils;

public class GameStage {

    private final int maxOfRound;
    private final Car[] cars;

    private GameStage(int maxOfRound, int numberOfCars) {
        this.maxOfRound = IntegerUtils.isPositiveNumber(maxOfRound);
        this.cars = new Car[numberOfCars];
    }

    public static GameStage start(GameConfigDto config) {

        return new GameStage(config.getMaxOfRound(), config.getNumberOfCars());
    }
}
