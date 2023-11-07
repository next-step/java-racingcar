package me.namuhuchutong.step4;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.stream.Stream;

public class RacingCarService {

    public RacingResult runRacing(UserInputInformation inputInformation) {
        Cars initializedCars = Cars.createCars(inputInformation.getCarNames());
       return repeatRace(initializedCars, inputInformation.getTimes());
    }

    private RacingResult repeatRace(Cars cars, int times) {
        List<Cars> collect = Stream.generate(cars::raceAllCars)
                                .limit(times)
                                .collect(toUnmodifiableList());
        return new RacingResult(collect);
    }
}
