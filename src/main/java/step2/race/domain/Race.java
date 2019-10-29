package step2.race.domain;

import step2.car.domain.Car;
import step2.car.domain.Status;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Race {
    private static final int NOBODY_MOVE = 0;

    private List<Car> cars;
    private List<RaceHistory> raceHistories = new ArrayList<>();

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public List<RaceHistory> getRaceHistories() {
        return Collections.unmodifiableList(this.raceHistories);
    }

    public void moveAll() {
        cars.forEach(Car::move);
        noteHistory();
    }

    private void noteHistory() {
        RaceHistory raceHistory = new RaceHistory(getAllStatus());
        raceHistories.add(raceHistory);
    }

    private List<Status> getAllStatus() {
        return this.cars.stream()
                .map(Car::getStatus)
                .collect(toList());
    }

    public RaceResult getResult() {
        List<Car> winners = findWinners();
        return new RaceResult(winners);
    }

    private List<Car> findWinners() {
        int max = getMaxPosition();

        return this.cars.parallelStream()
                .filter(car -> car.getPosition() == max)
                .collect(toList());
    }

    private Integer getMaxPosition() {
        return this.cars.parallelStream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElse(NOBODY_MOVE);
    }
}
