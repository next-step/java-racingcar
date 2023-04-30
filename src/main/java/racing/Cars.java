package racing;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> names) {
        this.cars = names.stream()
            .map(Car::new)
            .collect(Collectors.toList());
    }

    public void move(MoveStrategy moveStrategy) {
        cars.forEach(car -> car.move(moveStrategy));
    }

    public List<CarDTO> getCarDTOs() {
        return cars.stream()
            .map(Car::getCarDTO)
            .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }
}
