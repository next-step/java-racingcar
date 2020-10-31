package step3.factory;

import step3.Constant;
import step3.car.Car;
import step3.car.RacingCar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarFactory implements CarFactory<RacingCar> {
    private static RacingCarFactory factory = new RacingCarFactory();

    private RacingCarFactory() {
        System.out.println(Constant.CREATED_INSTANCE);
    }

    public static RacingCarFactory getFactory() {
        return factory;
    }

    @Override
    public Car createCar() {
        return new RacingCar();
    }

    @Override
    public List<Car> createCars(Integer number) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            cars.add(new RacingCar());
        }
        return cars;
    }
}
