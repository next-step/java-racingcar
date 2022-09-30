package car.factory;

import car.domain.Car;
import car.domain.NamingRacingCar;
import car.strategy.CarMovableStrategy;

import java.util.ArrayList;
import java.util.List;

public class NamingCarFactory {

    public List<Car> generateCar(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            NamingRacingCar namingRacingCar = generateCar();
            namingRacingCar.inputName(carName);
            cars.add(namingRacingCar);
        }
        return cars;
    }

    private NamingRacingCar generateCar() {
        return new NamingRacingCar(new CarMovableStrategy());
    }
}
