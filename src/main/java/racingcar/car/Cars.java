package racingcar.car;

import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars = new ArrayList<>();

    public void setUserInputCountOfCar() {
        addCars(InputView.inputCountOfCar());
    }

    private void addCar(Car car) {
        cars.add(car);
    }

    public void addCars(int countOfCar) {
        for (int i = 0; i < countOfCar; i++) {
            addCar(new Car());
        }
    }

    public void moveCars() {
        for (Car car : cars) {
            car.movePosition();
        }
        System.out.println();
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
