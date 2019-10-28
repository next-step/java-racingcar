package step2.race.domain;

import step2.car.domain.Car;
import step2.car.domain.Status;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Race {
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
}
