package racingcar.domain;

import racingcar.domain.car.Car;
import racingcar.domain.car.RacingCars;
import racingcar.domain.numbergenerator.RandomNumberGenerator;
import step2.PositiveInteger;

import java.util.List;

public class Race {

    private final PositiveInteger raceCount;
    private final List<RacingCars> cars;

    private Race(PositiveInteger raceCount, List<RacingCars> racingCars) {
        this.raceCount = raceCount;
        this.cars = racingCars;
    }

    public static Race from(int raceCount, List<Car> cars){
        PositiveInteger positiveRaceCount = PositiveInteger.from(raceCount);

        return new Race(positiveRaceCount, List.of(new RacingCars(cars, new RandomNumberGenerator())));
    }

    public List<RacingCars> race(){
        for(int i = 0; i < raceCount.getValue(); i++){
            cars.get(i).raceCar();
            cars.add(cars.get(i).copy(cars.get(i)));
        }

        return cars;
    }

}
