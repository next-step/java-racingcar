package step_3.service;

import step_3.domain.RacingCar;
import step_3.domain.RacingCars;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingCarService {

    public RacingCars composedRacingCars(List<RacingCar> racingCars) {
        return new RacingCars(racingCars);
    }

    public List<RacingCar> createRacingCars(int totalRacingCarCount) {
        return Stream.generate(RacingCar::new)
                .limit(totalRacingCarCount)
                .collect(Collectors.toList());
    }
}
