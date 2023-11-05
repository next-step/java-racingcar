package me.namuhuchutong.step3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingService {

    private final RacingRule racingRule;

    public RacingService(RacingRule racingRule) {
        this.racingRule = racingRule;
    }

    public RacingResult runRacing(UserInputInformation userInputInformation) {
        validateTimes(userInputInformation.getTimes());
        Cars initalizedCars = Cars.createCars(userInputInformation.getNumberOfCars());
        return repeatRacing(initalizedCars, userInputInformation.getTimes());
    }

    private void validateTimes(int times) {
        if (times <= 0) {
            throw new IllegalArgumentException("자동차 경주 횟수는 음수이거나 0일 수 없습니다 - " + times);
        }
    }

    private RacingResult repeatRacing(Cars initalizedCars, int times) {
        List<Cars> collect = Stream.generate(() -> initalizedCars.raceAllCars(racingRule))
                                   .limit(times)
                                   .collect(Collectors.toList());
        return new RacingResult(collect);
    }
}
