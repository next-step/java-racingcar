package game.race.support;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import game.race.Car;
import game.race.support.move.MovePolicy;

public class Cars {

    private static final List<Car> cars = new ArrayList<>();

    public static List<Car> of(List<String> vehicleNames, MovePolicy movePolicy) {
        cars.addAll(vehicleNames.stream()
                                .map(name -> new Car(name, movePolicy))
                                .collect(Collectors.toList()));

        return cars;
    }

    public static List<String> getWinners() {
        int maxMoveCount = 0;
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            maxMoveCount = Math.max(maxMoveCount, car.getMoveCount());
        }

        for (Car car : cars) {
            if (maxMoveCount == car.getMoveCount()) {
                winners.add(car.getName());
            }
        }

        return winners;
    }
}
