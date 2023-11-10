package racing.view;

import racing.domain.Car;

import java.util.List;

public class ResultView {
    public static void display(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            System.out.println("-".repeat(cars.get(i).getDistance()));
        }
    }
}
