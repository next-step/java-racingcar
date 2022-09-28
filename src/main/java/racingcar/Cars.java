package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    public static final int MIN_WINNER_POSITION = 0;
    private final List<Car> cars;

    public Cars(List<String> names) {
        cars = initCars(names);
    }

    private List<Car> initCars(List<String> names) {
        List<Car> resultCars = new ArrayList<>();
        names.forEach(
                name -> resultCars.add(new Car(name))
        );
        return resultCars;
    }

    public List<CarStatusDto> move() {
        cars.forEach(car -> car.move(new CarCondition()));
        return getCarStatus();
    }

    private List<CarStatusDto> getCarStatus() {
        List<CarStatusDto> carStatusDtos = new ArrayList<>();
        cars.forEach(car -> carStatusDtos.add(createCarStatusDto(car)));
        return carStatusDtos;
    }

    public List<CarStatusDto> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(this::createCarStatusDto)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(MIN_WINNER_POSITION);
    }

    private CarStatusDto createCarStatusDto(Car car) {
        return new CarStatusDto(car.getPosition(), car.getName());
    }
}
