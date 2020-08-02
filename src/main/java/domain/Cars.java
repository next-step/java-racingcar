package domain;

import view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {
    private final List<Car> cars = new ArrayList();
    private final Random random = new Random();

    public Cars(int numberOfCar) {
        for (int i = 0; i < numberOfCar; i++) {
            cars.add(new Car());
        }
    }

    public void race() {
        for (Car car : cars) {
            int randomNumber = random.nextInt(10);

            car.move(randomNumber);
            ResultView.print(cars);
        }
    }

    public int getNumberOfCars() {
        return cars.size();
    }
}
