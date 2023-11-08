package me.namuhuchutong.step4.domain;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.stream.Stream;
import me.namuhuchutong.step4.domain.rule.RacingRule;
import me.namuhuchutong.step4.dto.RacingResult;
import me.namuhuchutong.step4.dto.UserInputInformation;

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
