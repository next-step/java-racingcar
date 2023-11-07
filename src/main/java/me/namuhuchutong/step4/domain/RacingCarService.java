package me.namuhuchutong.step4.domain;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.NoSuchElementException;
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
        Cars finishedResult = collect.get(collect.size() - 1);
        return new RacingResult(collect, getWinners(finishedResult));
    }

    private List<String> getWinners(Cars cars) {
        Car winnerCar = cars.getValues()
                            .stream()
                            .max(comparingInt(Car::getPosition))
                            .orElseThrow(NoSuchElementException::new);
        return cars.getValues()
                   .stream()
                   .filter(car -> car.getPosition() == winnerCar.getPosition())
                   .map(Car::getName)
                   .collect(toUnmodifiableList());
    }
}
