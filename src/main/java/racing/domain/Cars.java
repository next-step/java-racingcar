package racing.domain;

import racing.domain.vo.Name;
import racing.domain.vo.Position;
import racing.util.NumberGenerator;
import racing.util.StringSplitter;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(String carNamesString) {
        this(createCars(carNamesString));
    }

    private static List<Car> createCars(String carNamesString) {
        List<String> carNames = StringSplitter.getNameList(carNamesString);
        return carNames.stream()
                .map(Name::new)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void move(int chance){
        cars.forEach(car ->
                car.move(chance));
    }

    public List<Car> cars() {
        return Collections.unmodifiableList(cars);
    }

    public Winners findWinners() {
        List<Car> carList = cars.stream()
                .filter(car -> car.isSamePosition(maxPosition()))
                .collect(Collectors.toList());
        return new Winners(carList);
    }

    private Position maxPosition() {
        Position maxPosition = new Position();
        for (Car car : cars)
            maxPosition = car.getBiggerPosition(maxPosition);

        return maxPosition;
    }
}
