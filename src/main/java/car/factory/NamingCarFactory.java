package car.factory;

import car.domain.Car;
import car.domain.NamingCar;
import car.strategy.CarMovableStrategy;

import java.util.ArrayList;
import java.util.List;

public class NamingCarFactory implements CarFactory {
    public List<Car> generateCar(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            NamingCar namingCar = generateCar();
            namingCar.inputName(carName);
            cars.add(namingCar);
        }
        return cars;
    }

    @Override
    public NamingCar generateCar() {
        return new NamingCar(new CarMovableStrategy());
    }
}
