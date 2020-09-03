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

    private List<Car> cars = null;
    private int racingCounts = 0;

    public RacingGame(String input, int racingCounts) {
        this.cars = this.generateCars(input);
        this.racingCounts = racingCounts;
    }

    private List<Car> generateCars(String input) { //createCars factory대신 createCars(input));
        List<Car> cars = new ArrayList<>();
        String[] carName = input.split(",");
        for (int i = 0 ; i < carName.length; i++) {
            Car car = new Car(carName[i]);
            cars.add(car);
        }
        return cars;
    }

    public List<Car> getCars() {
        return cars;
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
        for (Car car : cars) {
            car.move2(returnRandom());
            newCarList.add(car);
        }
        Cars carList = new Cars(newCarList);
        return carList;
    }

}