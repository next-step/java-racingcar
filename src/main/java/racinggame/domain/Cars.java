package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> carList;

    public static Cars createCars(List<String> carNames) {
        if (carNames.size() == 1) {
            throw new IllegalArgumentException("경기를 위한 자동차는 최소 2대는 필요합니다.");
        }

        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        return new Cars(cars);
    }

    private Cars(List<Car> cars) {
        this.carList = new ArrayList<>(cars);
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<Car> carMove() {
        return carList.stream()
                .map(car -> {
                    car.move();
                    return new Car(car.getCarName(), car.getPosition());
                })
                .collect(Collectors.toList());
    }
}
