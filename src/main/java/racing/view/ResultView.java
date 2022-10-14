package racing.view;

import racing.domain.Car;

import java.util.List;

public class ResultView {
    private static final String DASH = "-";

    public static void init() {
        System.out.println("실행 결과");
    }

    public void result(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + ":" + DASH.repeat(car.getDistance()));
            System.out.println("");
        }
    }
}
