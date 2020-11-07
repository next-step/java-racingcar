package racing.ui;

import racing.Car;

import java.util.List;

public class ResultView {

    public static void output(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getStr());
        }
        System.out.println();
    }
}
