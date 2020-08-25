package racingcar.domain;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.car.WinnerCars;

import java.util.List;
import java.util.Objects;

import static racingcar.domain.car.CarFactory.createCars;

public class RacingGame {

    private final Cars cars;
    private final RacingCounts racingCounts;

    public RacingGame(String input, int racingCounts) {
        this.cars = new Cars(createCars(input));
        this.racingCounts = new RacingCounts(racingCounts);
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public int getRacingCounts() {
        return racingCounts.getRacingCounts();
    }

    public List<Car> recordRacing() {
        RaceResults raceResults = new RaceResults(getCars());
        cars.moveCars();
        return raceResults.getRaceResults();
    }

    public String recordWinnerCars() {
        WinnerCars winnercars = new WinnerCars(cars.findWinners());
        return winnercars.getWinnersNames();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;
        RacingGame that = (RacingGame) o;
        return Objects.equals(cars, that.cars) &&
                Objects.equals(racingCounts, that.racingCounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, racingCounts);
    }
}
