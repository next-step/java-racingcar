package view;

import java.util.List;
import racing.Car;

public class ResultView {

    private List<Car> cars;

    public ResultView(List<Car> cars) {
        this.cars = cars;
    }

    public void broadcast() {
        for (Car car : cars) {
            getRandomNumber(car.currentPosition());
            System.out.println();
        }
    }

    private void getRandomNumber(int currentPosition) {
        for (int i = 0; i < currentPosition; i++) {
            System.out.print("-");
        }
    }
}
