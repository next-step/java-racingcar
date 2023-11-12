package racingcarwinner.view;

import racingcarwinner.domain.Car;

import java.util.List;

public class OutputView {

    private static final String MOVING_STATUS = "-";

    public void output(List<Car> carList) {
        carList.stream().forEach(car -> System.out.println(car.name() + " : " + MOVING_STATUS.repeat(car.location())));
        System.out.println();
    }

    public void result(String winner) {
        System.out.println(winner + "가 최종 우승했습니다.");
    }
}
