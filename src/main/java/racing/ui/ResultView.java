package racing.ui;

import racing.domain.Car;

import java.util.List;

public class ResultView {
    public static void print(final List<Car> cars) {
        System.out.println("실행 결과");

        for (Car car : cars) {
            System.out.println(car.getDistance());
        }
    }
}
