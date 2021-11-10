package racingcar.view.result;

import java.util.List;
import racingcar.domain.Car;

import java.util.stream.Collectors;

public class CarNameResultView implements ResultView {

    @Override
    public void printRoundResult(Car car) {
        System.out.println(car.getName() + ":" + car.printPosition());
    }

    @Override
    public void printWinner(List<Car> winners) {
        String winnerCarNames = winners.stream()
                                        .map(car -> car.getName())
                                        .collect(Collectors.joining(","));
        System.out.println(winnerCarNames + "가 최종 우승했습니다.");
    }
}
