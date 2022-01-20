package racingcar;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.domain.Car;
import racingcar.domain.View;
import racingcar.utils.Randoms;

public class Game {

    private final List<Car> cars;

    private final int CONDITION_MOVE_AVAILABLE = 4;
    private final int turn;

    public Game(List<Car> cars, int turn) {
        this.cars = cars;
        this.turn = turn;
    }

    public void play() {
        View.printTurnResult();
        IntStream.range(0, turn)
            .forEach(
                index -> {
                    cars.stream()
                        .forEach(car -> {
                            increaseIfAvailable(car);
                            View.printDistance(car);
                        });
                    System.out.println();
                }
            );
        View.printWhoIsWinner(calculateMaxWinners());
    }

    private void increaseIfAvailable(Car car) {
        int random = Randoms.getRandomIntWithinRange(0, 9);
        if (random >= CONDITION_MOVE_AVAILABLE) {
            car.increaseDistance();
        }
    }

    private String calculateMaxWinners() {
        List<Integer> distances = cars.stream()
            .map(car -> car.distance())
            .collect(Collectors.toList());

        return cars.stream()
            .filter(car -> car.distance() == Collections.max(distances))
            .map(Car::name)
            .collect(Collectors.joining(", "));
    }
}
