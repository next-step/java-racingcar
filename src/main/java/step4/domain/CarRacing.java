package step4.domain;

import step4.model.Record;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarRacing {

    private final String[] players;
    private final int numTry;

    public CarRacing(String[] players, int numTry) {
        this.players = players;
        this.numTry = numTry;
    }

    public List<List<Record>> carRacing(List<Car> carList, MoveStrategy randomMoveStrategy) {
        return Stream.iterate(0, i -> i < numTry, i -> i + 1)
                .map(i -> race(carList, randomMoveStrategy))
                .collect(Collectors.toList());
    }

    public List<Record> race(List<Car> carList, MoveStrategy randomMoveStrategy) {
        return carList.stream()
                .peek(car -> car.tryMove(randomMoveStrategy))
                .map(car -> new Record(car.getPlayer(), car.getDistance()))
                .collect(Collectors.toList());
    }

    public List<Car> createCarList() {
        return Arrays.stream(players)
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
