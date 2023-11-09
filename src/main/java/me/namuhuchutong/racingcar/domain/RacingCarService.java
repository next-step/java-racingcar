package me.namuhuchutong.racingcar.domain;


import java.util.ArrayList;
import java.util.List;
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
        List<Cars> collect = new ArrayList<>();
        for (int i = 0; i < times; i++) {
            Cars finishedCars = cars.raceAllCars(racingRule);
            collect.add(finishedCars);
            cars = finishedCars;
        }
        return new RacingResult(collect, cars.getWinners());
    }
}
