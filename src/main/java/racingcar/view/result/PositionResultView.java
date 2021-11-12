package racingcar.view.result;

import racingcar.domain.Car;

import java.util.*;

public class PositionResultView implements ResultView {

    @Override
    public void printRoundResult(List<Car> carList) {
        carList.forEach(
                car -> System.out.println(car.printPosition())
        );
    }

    @Override
    public void printWinner(List<Car> winners) {
    }
}
