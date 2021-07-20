package racingcar;

import racingcar.car.Cars;
import racingcar.dto.CarDto;
import racingcar.strategy.MoveStrategy;

import java.util.List;

public class RacingCar {
    private static final int MINIMUM_ROUND = 1;
    private final int totalRound;
    private final Cars cars;
    private int currentRound;

    private RacingCar(int numberOfCars, int totalRound, MoveStrategy moveStrategy) {
        validate(totalRound);

        this.totalRound = totalRound;
        this.currentRound = 0;
        this.cars = Cars.of(numberOfCars, moveStrategy);
    }

    private void validate(int totalRound) {
        if (totalRound < MINIMUM_ROUND) {
            throw new IllegalArgumentException("Total round can't be under zero");
        }
    }

    public static RacingCar init(int numberOfCars, int totalRound, MoveStrategy moveStrategy) {
        return new RacingCar(numberOfCars, totalRound, moveStrategy);
    }

    public void race() {
        if (isRaceOver()) {
            throw new IllegalStateException("Round can't exceed total round");
        }

        currentRound++;
        cars.moveCars();
    }

    public boolean isRaceOver() {
        return currentRound >= totalRound;
    }

    public List<CarDto> currentState() {
        return cars.getCarDtos();
    }
}
