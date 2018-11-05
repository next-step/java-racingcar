package racinggame.car;

import racinggame.car.Car;

import java.util.List;
import java.util.stream.Collectors;

public class VictoryCar {
    List<Car> cars;

    public VictoryCar(List<Car> cars) {
        this.cars = cars;
    }

    public int getMaxLocation() {
        return cars.stream().collect(Collectors.summarizingInt(Car::getLocation)).getMax();
    }

    public List<String> getVictorCar(){
        int maxLocation = getMaxLocation();
        return cars.stream()
                .filter(car -> car.equalsPosition(maxLocation))
                .map(Car::getName)
                .collect(Collectors.toList());
    }


}
