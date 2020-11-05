package humbledude.carracing.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Car> getWinners() {
        int winnersPosition = getWinnersPosition();

        return cars.stream()
                .filter(car -> car.getPosition() == winnersPosition)
                .collect(Collectors.toList());
    }

    private int getWinnersPosition() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .get()
                .getPosition();
    }
}
