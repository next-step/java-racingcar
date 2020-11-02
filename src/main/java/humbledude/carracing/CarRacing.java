package humbledude.carracing;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {

    private List<Car> cars;
    private FuelGenerator fuelGenerator;

    public CarRacing(List<Car> cars, FuelGenerator fuelGenerator) {
        this.cars = cars;
        this.fuelGenerator = fuelGenerator;
    }

    public void playOneTurn() {
        for (Car car : cars) {
            int fuel = fuelGenerator.generate();
            car.accelerate(fuel);
        }
    }


}
