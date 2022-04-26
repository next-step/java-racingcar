package study.step4.domain;

import study.step4.controller.CarsPositionModel;
import study.step4.domain.strategy.MoveStrategy;
import study.step4.domain.strategy.RandomMoveStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Cars {
    private static final String NULL_POINTER_MOVE_STRATEGTY = "move 전략이 null 입니다";
    private static final int FIRST_CAR_INDEX = 0;
    private final List<Car> cars = new ArrayList<>();

    public Cars(String[] cars) {
        Arrays.stream(cars)
                .map(car -> new Car(new CarName(car)))
                .forEach(this.cars::add);
    }

    public List<CarsPositionModel> toCarsPositionModel() {
        return cars.stream()
                .map(CarsPositionModel::from)
                .collect(toList());
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy == null) {
            throw new NullPointerException(NULL_POINTER_MOVE_STRATEGTY);
        }

        for (Car car : cars) {
            car.move(moveStrategy);
        }

    }

    public List<String> winners() {
        Collections.sort(cars, new CarComparator());
        int max = cars.get(FIRST_CAR_INDEX).position();

        return cars.stream()
                .filter(c -> c.position() == max)
                .map(Car::name)
                .collect(Collectors.toList());
    }
}
