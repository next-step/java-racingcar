package racingcar;

import java.util.List;

public class OutView {
    public void printResult(List<Car> carList) {
        for (Car car: carList) {
            System.out.println(car.printMovedDistance());
        }
    }
}