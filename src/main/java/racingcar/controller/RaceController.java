package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.CarCollection;
import racingcar.strategy.MoveStrategy;
import racingcar.strategy.RandomMoveStrategy;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class RaceController {

    private static final MoveStrategy MOVE_STRATEGY = new RandomMoveStrategy();
    private static final String CAR_NAME_SPLIT = ",";

    public void startRace(String carNames, int moveNumber) {
        CarCollection carFactory = new CarCollection();
        OutputView outputView = new OutputView();
        List<String> carNameList = getCarNames(carNames);
        carFactory.participants(carNameList);
        List<Car> cars = carFactory.getCars();

        for (int i = 0; i < moveNumber; i++) {
            moveCars(cars);
            outputView.print(cars.stream().map(Car::toString).collect(Collectors.toList()));
        }
        outputView.print(getWinner(cars));
    }

    public List<String> getCarNames(String carNames) {
        return List.of(carNames.split(CAR_NAME_SPLIT));
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
