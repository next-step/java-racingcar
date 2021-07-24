package racingcar.car;

import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    public List<Car> cars = new ArrayList<>();

    private void addCar(Car car) {
        cars.add(car);
    }

    public void addCars(int countOfCar) {
        for (int i = 0; i < countOfCar; i++) {
            addCar(new Car());
        }
    }

    public void race() {
        for (Car car : cars) {
            car.move();
            ResultView.printCarPositionStatus(car.getPosition());
        }
        System.out.println();
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
