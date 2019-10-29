package step2.race.domain;

import step2.car.domain.Car;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class RaceResult {

    private List<Car> winners;

    public RaceResult(List<Car> winners) {
        this.winners = winners;
    }

    public List<String> getWinnersNames() {
        return this.winners.stream()
                .map(Car::getName)
                .collect(toList());
    }
}
