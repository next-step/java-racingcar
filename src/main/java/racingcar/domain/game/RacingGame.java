package racingcar.domain.game;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.record.RacingRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static racingcar.domain.record.RacingRecord.of;
import static racingcar.domain.car.CarFactory.createCars;

public class RacingGame {

    private final Cars cars;
    private final RacingCounts racingCounts;
    private final List<RacingRecord> racingRecordList;

    public RacingGame(String input, int racingCounts) {
        this.cars = new Cars(createCars(input));
        this.racingCounts = new RacingCounts(racingCounts);
        this.racingRecordList = new ArrayList<>();
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public int getRacingCounts() {
        return racingCounts.getRacingCounts();
    }

    public List<RacingRecord> getRacingRecordList() {
        return racingRecordList;
    }

    public void start() {
        for (int i = 0 ; i < getRacingCounts() ; i++) {
            cars.moveCars();
            racingRecordList
                    .add(of(new Cars(getCars())));
        }
    }

    public String findWinners() {
        return cars.findWinnersNames();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;
        RacingGame that = (RacingGame) o;
        return Objects.equals(cars, that.cars) &&
                Objects.equals(racingCounts, that.racingCounts) &&
                Objects.equals(racingRecordList, that.racingRecordList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, racingCounts, racingRecordList);
    }
}
