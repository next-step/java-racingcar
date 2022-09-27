package racingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(int n) {
        this.cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cars.add(new Car());
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public Cars createCars(String carNames) {
        String[] sCars = carNames.split(",");
        for (String sCar : sCars) {
            cars.add(new Car().createCar(sCar));
        }
        return this;
    }

    public void playGame() {
        for (Car car : this.cars) {
            car.play(new Random());
        }
    }
}
