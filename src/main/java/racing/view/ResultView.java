package racing.view;

import racing.entity.Car;

import java.util.List;

public class ResultView {
    public void printResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + ": ");
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
        }
    }
}
