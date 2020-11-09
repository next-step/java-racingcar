package racingcar.service;

import racingcar.dto.RaceReadyValue;
import racingcar.dto.RaceResultValue;
import racingcar.dto.StepByCar;
import racingcar.model.Cars;
import racingcar.model.Motor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RacingCarService {

    private static final int RANGE_START_NUM = 0;

    public static RaceResultValue play(RaceReadyValue raceReadyValue, Motor motor) {
        List<StepByCar> stepByCars = new ArrayList<>();
        int stepCount = raceReadyValue.getTryCount();

        Cars cars = Cars.of(raceReadyValue.getCarNames(), motor);

        IntStream.range(RANGE_START_NUM, stepCount)
                .forEach(i -> {
                    cars.run();
                    stepByCars.addAll(cars.getStepByCar());
                });

        return RaceResultValue.of(stepCount, stepByCars);
    }
}
