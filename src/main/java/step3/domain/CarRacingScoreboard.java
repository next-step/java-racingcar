package step3.domain;

import step3.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacingScoreboard {

    private static List<List<Integer>> scoreboard = new ArrayList<>();

    public static void recordScoreboard(List<Car>cars) {
        scoreboard.add(cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList()));
    }

    public static List<List<Integer>> getScoreboard() {
        return scoreboard;
    }

}
