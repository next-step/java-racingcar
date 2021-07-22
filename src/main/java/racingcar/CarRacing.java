package racingcar;

import racingcar.car.Cars;
import racingcar.dto.CarDto;
import racingcar.param.CarRacingInitParams;
import racingcar.strategy.MoveStrategy;

import java.util.List;

public class CarRacing {
    private static final int START_ROUND = 0;
    private static final int MINIMUM_ROUND = 1;
    private final int totalRound;
    private final Cars cars;
    private int currentRound;

    private CarRacing(int totalRound, String... names) {
        validate(totalRound);

        this.totalRound = totalRound;
        this.currentRound = START_ROUND;
        this.cars = Cars.init(names);
    }

    private void validate(int totalRound) {
        if (totalRound < MINIMUM_ROUND) {
            throw new IllegalArgumentException("Total round can't be under " + MINIMUM_ROUND);
        }
    }

    public static CarRacing init(CarRacingInitParams carRacingInitParams) {
        return new CarRacing(carRacingInitParams.getTotalRound(), carRacingInitParams.getNames());
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

    public List<String> getLeaders() {
        return cars.getLeaders();
    }
}
