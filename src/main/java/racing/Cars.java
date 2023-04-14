package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(Integer numberOfCar) {
        if (isZeroOrLess(numberOfCar)) {
            throw new RuntimeException("Never allows the number of cars to be zero or less");
        }
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numberOfCar; i++) {
            cars.add(new Car());
        }
        this.cars = cars;
    }

    public void move(MoveStrategy moveStrategy) {
        cars.forEach(car -> car.move(moveStrategy));
    }

    public List<CarDTO> getCarDTOs() {
        return cars.stream()
            .map(Car::getCarDTO)
            .collect(Collectors.toList());
    }

    private static boolean isZeroOrLess(Integer numberOfCar) {
        return numberOfCar <= 0;
    }

}
