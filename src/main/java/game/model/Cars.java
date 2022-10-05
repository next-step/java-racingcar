package game.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> carList;

    public Cars(List<String> carNames) {
        this.carList = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void moveCarList(MovableStrategy movableStrategy) {
        for (Car v : this.carList) {
            v.move(movableStrategy);
        }
    }

    public List<Car> getLocatedHighPositionCars() {
        List<Car> locatedHighPositionCarList = new ArrayList<>();
        for (Car car : this.carList) {
            addToHighPositionCars(locatedHighPositionCarList, car, getMaxPosition());
        }
        return Collections.unmodifiableList(locatedHighPositionCarList);
    }

    private void addToHighPositionCars(List<Car> result, Car car, int maxPosition) {
        if (car.getPosition() >= maxPosition) {
            result.add(car);
        }
    }
    private int getMaxPosition() {
        return Collections.max(this.carList.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList()));
    }

    public List<Car> getCarList() {
        return Collections.unmodifiableList(carList);
    }
}
