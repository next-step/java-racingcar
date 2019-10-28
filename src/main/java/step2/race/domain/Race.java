package step2.race.domain;

import step2.car.domain.car.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private List<Car> cars;
    private List<RaceHistory> raceHistories = new ArrayList<>();

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public List<RaceHistory> getRaceHistories() {
        return new ArrayList<>(raceHistories);
    }

    public void moveAll() {
        cars.forEach(Car::move);
        noteHistory();
    }

    private void noteHistory() {
        RaceHistory raceHistory = new RaceHistory(getAllPosition());
        raceHistories.add(raceHistory);
    }

    private List<Integer> getAllPosition() {
        return this.cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());
    }
}
