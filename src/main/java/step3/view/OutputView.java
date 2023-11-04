package step3.view;

import step3.domain.Car;

import java.util.List;

public class OutputView {

    public void printCars(List<Car> cars) {
        for (Car car : cars) {
            printCar(car.position());
        }
        System.out.println();
    }

    public void printCar(int position) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < position; i++) {
            result.append("-");
        }
        System.out.println(result);
    }
}
