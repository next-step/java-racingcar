package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.CarCollection;
import racingcar.strategy.MoveStrategy;
import racingcar.strategy.RandomMoveStrategy;
import racingcar.validite.ValidityCheck;
import racingcar.view.OutputView;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class RaceController {

    private static final MoveStrategy MOVE_STRATEGY = new RandomMoveStrategy();
    private static final String CAR_NAME_SPLIT = ",";

    public void startRace(String carNames, int moveNumber) {
        ValidityCheck.positiveNumberCheck(moveNumber);
        List<String> carNameList = getCarNames(carNames);
        CarCollection carFactory = new CarCollection();
        carFactory.participants(carNameList);
        List<Car> cars = carFactory.getCars();
        OutputView outputView = new OutputView();

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
        List<String> winners = cars.stream()
                .filter(car -> car.position() == winnerPosition)
                .map(Car::name).collect(Collectors.toList());

        StringJoiner result = new StringJoiner(", ");
        winners.forEach(result::add);

        return result + "가 최종 우승했습니다.";
    }

    private int getMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::position)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("최대값이 없습니다."));
    }
}
