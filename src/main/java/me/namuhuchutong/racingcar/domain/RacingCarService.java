package me.namuhuchutong.racingcar.domain;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.stream.Stream;
import me.namuhuchutong.racingcar.domain.rule.RacingRule;
import me.namuhuchutong.racingcar.dto.RacingResult;
import me.namuhuchutong.racingcar.dto.UserInputInformation;

public class RacingCarService {

    private final RacingRule racingRule;

    public RacingCarService(RacingRule racingRule) {
        this.racingRule = racingRule;
    }

    public RacingResult runRacing(UserInputInformation inputInformation) {
        Cars initializedCars = Cars.createCars(inputInformation.getCarNames());
        return repeatRace(initializedCars, inputInformation.getTimes());
    }

    private RacingResult repeatRace(Cars cars, int times) {
        List<Cars> collect = Stream.generate(() -> cars.raceAllCars(racingRule))
                                   .limit(times)
                                   .collect(toUnmodifiableList());
        return new RacingResult(collect, cars.getWinners());
    }
}
