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
    private final List<RaceResults> raceResults;

    public RacingGame(String input, int racingCounts) {
        this.cars = new Cars(createCars(input));
        this.racingCounts = new RacingCounts(racingCounts);
        this.input = input;
        this.raceResults = new ArrayList<>();
    }

    public Cars getCars() {
        return cars;
    }

    public int getRacingCounts() {
        return racingCounts.getRacingCounts();
    }

    public String getInput() {
        return input;
    }

    public List<RaceResults> getRaceResults() {
        return raceResults;
    }

    public List<List<Car>> RacingAll() {
        List<List<Car>> carsAfterAllRace = new ArrayList<>();
        for (int i = 0 ; i < getRacingCounts() ; i++) {
            carsAfterAllRace.add(RacingOnce());
            raceResults.add(RaceResults.of(i, cars));
        }
        return carsAfterAllRace;
    }

    private List<Car> RacingOnce() {
        List<Car> carsAfterOneRace = new ArrayList<>();
        cars.moveCars();
        Cars newCars = new Cars(createCars(input));
        carsAfterOneRace.addAll(newCars.getCars());
        return carsAfterOneRace;
    }

    public String findWinners() {
        return cars.getWinnersNames();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;
        RacingGame that = (RacingGame) o;
        return Objects.equals(cars, that.cars) &&
                Objects.equals(racingCounts, that.racingCounts) &&
                Objects.equals(input, that.input) &&
                Objects.equals(raceResults, that.raceResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, racingCounts, input, raceResults);
    }
}
