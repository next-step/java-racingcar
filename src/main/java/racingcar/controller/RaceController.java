package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.CarFactory;
import racingcar.strategy.MoveStrategy;
import racingcar.strategy.RandomMoveStrategy;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class RaceController {

    private static final MoveStrategy MOVE_STRATEGY = new RandomMoveStrategy();

    public void startRace(String carNumber, int moveNumber) {
        CarFactory carFactory = new CarFactory();
        OutputView outputView = new OutputView();
        carFactory.participants(carNumber);
        List<Car> cars = carFactory.carsInfo();

        for (int i = 0; i < moveNumber; i++) {
            moveCars(cars);
            outputView.print(cars.stream().map(Car::toString).collect(Collectors.toList()));
        }
        outputView.print(getWinner(cars));
    }

    public void moveCars(List<Car> cars) {
        for (Car car : cars) {
            car.move(MOVE_STRATEGY.move());
        }
    }

    public String getWinner(List<Car> cars) {
        int winnerPosition = getMaxPosition(cars);
        List<String> winners = new ArrayList<>();

        cars.stream().filter(car -> car.position() == winnerPosition).forEach(car -> winners.add(car.name()));

        StringJoiner result = new StringJoiner(", ");
        winners.forEach(result::add);

        return result + "가 최종 우승했습니다.";
    }

    public int getMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.position());
        }
        return maxPosition;
    }
}
