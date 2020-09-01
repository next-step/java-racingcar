package racingcar.domain;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.strategy.condition.OneOrZeroForwardCondition;
import racingcar.strategy.raceStrategy.DoOneForward;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static racingcar.domain.car.CarFactory.createCars;
import static racingcar.utils.RandomInt.returnRandom;

public class RacingGame {

    private final Cars cars;
    private final int racingCounts;

    public RacingGame(String input, int racingCounts) {
        this.cars = new Cars(createCars(input));
        this.racingCounts = racingCounts;
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public List<Cars> startRace() {
        List<Cars> raceResults = new ArrayList<>();
        for (int i = 0 ; i < racingCounts; i++) {
            raceResults.add(play());
        }
        return raceResults;
    }

    private Cars play() {
        List<Car> newCarList = new ArrayList<>();
        for (Car car : cars.getCars()) {
            car.move2(returnRandom());
            newCarList.add(car);
        }
        Cars carList = new Cars(newCarList);
        return carList;
    }

}