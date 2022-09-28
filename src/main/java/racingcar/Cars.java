package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> names) {
        cars = initCars(names);
    }

    public List<CarStatusDto> move() {
        cars.forEach(car -> car.move(new CarCondition()));
        return getCarStatus();
    }

    private List<CarStatusDto> getCarStatus() {
        List<CarStatusDto> carStatusDtos = new ArrayList<>();
        cars.forEach(
                car -> carStatusDtos.add(new CarStatusDto(car.getPosition(), car.getName()))
        );
        return carStatusDtos;
    }

    private List<Car> initCars(List<String> names) {
        List<Car> resultCars = new ArrayList<>();
        names.forEach(
                name -> resultCars.add(new Car(name))
        );
        return resultCars;
    }
}
