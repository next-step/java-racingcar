package racing.model;

import racing.model.strategy.NumberGeneratorStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Cars {
    public static final int START_PROGRESS = 0;
    public static final int NUMBER_RANGE = 10;
    private final List<RacingCar> cars;

    Cars(List<RacingCar> cars) {
        this.cars = cars;
    }

    public List<String> getWinnerNames() {
        return cars.stream()
                .filter(car -> car.isSameProgress(getTopSpeed()))
                .map(RacingCar::getName)
                .collect(Collectors.toList());
    }

    public List<RacingCar> cars() {
        return this.cars;
    }

    public void raceAllCars(NumberGeneratorStrategy strategy){
        for (RacingCar car : this.cars) {
            car.race(strategy.generateNumber(NUMBER_RANGE));
        }
    }

    public int getTopSpeed() {
        int max = 0;
        for (RacingCar car : cars) {
            max = car.max(max);
        }
        return max;
    }

    public static Cars of(Names names) {
        List<RacingCar> cars = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            cars.add(new RacingCar(START_PROGRESS, names.name(i)));
        }
        return new Cars(cars);
    }

}
