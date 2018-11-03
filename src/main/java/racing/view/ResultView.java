package racing.view;

import racing.Car;

import java.util.List;

public class ResultView {

    public void showResult(List<Car> cars) {
        for (Car car : cars) {
            showEachCar(car);
        }
        System.out.println();
    }

    private void showEachCar(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
