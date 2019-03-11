package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private List<Car> cars;


    public List<Car> getCars() {
        return cars;
    }

    public Race(String carNames) {
        this.cars = setupCar(carNames);
    }

    private List<Car> setupCar(String carNames) {
        cars = new ArrayList<>();
        String[] names = carNames.split(",");
        for (String name : names) {
            cars.add(new Car(name.trim()));
        }
        return cars;
    }

    public void run() {
        for (Car car : cars) {
            if (car.canMove()) {
                car.moveCar();
            }
        }
    }


}
