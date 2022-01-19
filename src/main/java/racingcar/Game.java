package racingcar;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.View;
import racingcar.utils.Randoms;

public class Game {

    private final List<Car> cars;
    private final int turn;
    private final int CONDITION_MOVE_AVAILABLE = 4;

    public Game(List<Car> cars, int turn) {
        this.cars = cars;
        this.turn = turn;
    }

    private void increaseIfAvailable(Car car) {
        int random = Randoms.getRandomIntWithinRange(0, 9);
        if (random >= CONDITION_MOVE_AVAILABLE) {
            car.increaseDistance();
        }
    }

    private String calculateMaxWinners() {
        StringBuilder sb = new StringBuilder();
        List<Integer> distances = cars.stream()
            .map(car -> car.distance())
            .collect(Collectors.toList());

        List<Car> winners = cars.stream()
            .filter(car -> car.distance() == Collections.max(distances))
            .collect(Collectors.toList());

        for (Car car: winners) {
            sb.append(car.name() + ", ");
        }

        return sb.delete(sb.length() - 2, sb.length()).toString();
    }

    public void play() {
        View.printTurnResult();
        for (int index = 0; index < turn; index++) {
            for (Car car: cars) {
                increaseIfAvailable(car);
                View.printDistance(car);
            }
            System.out.println();
        }
        View.printWhoIsWinner(calculateMaxWinners());
    }
}
