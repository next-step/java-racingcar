package car;

import java.util.ArrayList;
import java.util.List;

public class ResultView {
    private List<Car> cars;

    public ResultView(List<Car> cars) {
        this.cars = cars;
    }

    public void print() {
        for (Car car : cars) {
            car.printDistance();
            System.out.println();
        }
    }
}
