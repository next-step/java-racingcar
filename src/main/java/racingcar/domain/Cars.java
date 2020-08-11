package racingcar.domain;

import racingcar.utils.CarMove;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {

    private List<Car> cars;

    public Cars(String[] name) {
        createCars(name);
    }

    public Stream<Car> stream() {
        return cars.stream();
    }

    public void createCars(String[] carNames) {
        cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    public void moveCars(CarMove carMove) {
        for (Car car : cars) {
            car.move(carMove.moveAble());
        }
    }

    public List<Car> winnerIs(Cars winner) {
        int max = getMaxPosition(winner);
        return winner.stream()
                .filter(car -> car.getPosition() == max)
                .collect(Collectors.toList());
    }

    public int getMaxPosition(Cars maxPosition) {
        return maxPosition.stream()
                .max(Comparator.comparing(Car::getPosition))
                .get()
                .getPosition();
    }

}
