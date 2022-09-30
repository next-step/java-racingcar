package car.factory;

import car.domain.Car;
import car.domain.RacingCar;
import car.strategy.CarMovableStrategy;

import java.util.ArrayList;
import java.util.List;

public class RacingCarFactory {

    public List<Car> generateCar(Integer num) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            cars.add(generateCar());
        }

        return cars;
    }

    private RacingCar generateCar() {
        return new RacingCar(new CarMovableStrategy());
    }
}
