package racingcar.view;

import racingcar.car.Car;

import java.util.List;

public class ResultView {

    private ResultView() {}

    public static void print(List<Car> carList) {
        for(Car car : carList) {
            System.out.println(car.printPosition());
        }
    }
}
