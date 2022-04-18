package study.step4.domain;

import study.step4.controller.CarsPositionModel;
import study.step4.domain.strategy.MoveStrategy;
import study.step4.domain.strategy.RandomMoveStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(String[] cars) {
        Arrays.stream(cars)
                .map(car -> new Car(new CarName(car)))
                .forEach(this.cars::add);
    }

    public List<CarsPositionModel> toCarsPositionModel() {
        return cars.stream()
                .map(car -> new CarsPositionModel(car.getCarName().getCarName(), car.getCarPosition().getPosition()))
                .collect(Collectors.toList());
    }

    public void move(MoveStrategy moveStrategy) {
        for (Car car : cars) {
            car.move(moveStrategy);
        }

    }

    public List<String> winners() {

        return null;
    }
}
