package me.namuhuchutong.step3;

import java.util.stream.IntStream;

public class RacingService {

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
        RacingRule racingRule = new RacingRule();
        RacingResult racingResult = new RacingResult();
        IntStream.range(0, times)
                 .mapToObj(i -> initalizedCars.raceAllCars(racingRule))
                 .forEach(racingResult::addFinishedRacing);
        return racingResult;
    }
}
