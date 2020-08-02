package step3.domain;

import step3.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacingScoreboard {

    private List<List<Integer>> scoreboard = new ArrayList<>();

    public void recordScoreboard(List<Car>cars) {
        scoreboard.add(cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList()));
    }

    public List<List<Integer>> getScoreboard() {
        return scoreboard;
    }

}
