package racingcar;

import racingcar.car.Cars;
import racingcar.dto.CarDto;
import racingcar.param.RacingCarInitParam;
import racingcar.strategy.MoveStrategy;

import java.util.List;

public class CarRacing {
    private static final int MINIMUM_ROUND = 1;
    private final int totalRound;
    private final Cars cars;
    private int currentRound;

    private CarRacing(int numberOfCars, int totalRound) {
        validate(totalRound);

        this.totalRound = totalRound;
        this.currentRound = 0;
        this.cars = Cars.from(numberOfCars);
    }

    private void validate(int totalRound) {
        if (totalRound < MINIMUM_ROUND) {
            throw new IllegalArgumentException("Total round can't be under zero");
        }
    }

    public static CarRacing init(RacingCarInitParam racingCarInitParam) {
        return new CarRacing(racingCarInitParam.getNumberOfCars(), racingCarInitParam.getTotalRound());
    }

    public void race(MoveStrategy moveStrategy) {
        if (isRaceOver()) {
            throw new IllegalStateException("Round can't exceed total round");
        }

        cars.moveCars(moveStrategy);
        currentRound++;
    }

    public boolean isRaceOver() {
        return currentRound >= totalRound;
    }

    public List<CarDto> currentState() {
        return cars.getCarDtos();
    }
}
