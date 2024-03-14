package racingcar.presentation;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private final String CAR_POSITION_PRINT_UNIT = "-";

    public void printMoveResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + carPosition(car));
        }
        System.out.println();
    }

    public void printWinner(List<Car> winners) {
        List<String> winnerNames = winners.stream().map(Car::getName).collect(Collectors.toList());
        System.out.println(String.join(",", winnerNames) + " 가 최종 우승했습니다.");
    }

    private String carPosition(Car car) {
        return CAR_POSITION_PRINT_UNIT.repeat(car.getPosition() + 1);
    }
}
