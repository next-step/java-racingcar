package car;

import java.util.ArrayList;

public class ResultView {
    private ArrayList<Car> cars = new ArrayList<>();

    public ResultView(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public void print() {
        for (Car car : cars) {
            System.out.println(car.getDistance());
        }
    }
}
