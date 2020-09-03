package racingcar.domain;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static racingcar.domain.car.CarFactory.createCars;

public class RacingGame {

    private final Cars cars;
    private final RacingCounts racingCounts;
    private final String input;

    public RacingGame(String input, int racingCounts) {
        this.input = input;
        this.cars = new Cars(createCars(input));
        this.racingCounts = new RacingCounts(racingCounts);
    }

    public Cars getCars() {
        return cars;
    }

    public String getInput() {
        return input;
    }

    public int getRacingCounts() {
        return racingCounts.getRacingCounts();
    }

    public List<List<Car>> recordAllRacing() {
        List<List<Car>> carsAfterAllRace = new ArrayList<>();
        for (int i = 0 ; i < racingCounts.getRacingCounts() ; i++) {
            carsAfterAllRace.add(recordOneRacing());
        }
        return carsAfterAllRace;
    }

    public List<Car> recordOneRacing() {
        List<Car> carsAfterOneRace = new ArrayList<>();
        cars.moveCars();
//        carsAfterOneRace.addAll(cars.getCars());
        Cars newCars = new Cars(createCars(input));
        carsAfterOneRace.addAll(newCars.getCars());

        return carsAfterOneRace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;
        RacingGame that = (RacingGame) o;
        return Objects.equals(cars, that.cars) &&
                Objects.equals(racingCounts, that.racingCounts) &&
                Objects.equals(input, that.input);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, racingCounts, input);
    }
}
