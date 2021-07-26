package step4;

import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class CarStadium {

    private final Referee referee;
    private final List<Car> cars;

    public CarStadium(Referee referee, List<Car> cars) {
        this.referee = referee;
        this.cars = cars;
    }

    public void enterCar(Car car) {
        cars.add(car);
    }

    public void moveCars() {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("자동차가 아직 입장이 안되었습니다.");
        }

        if (referee.isOverTime()) {
            throw new IllegalArgumentException("더 이상 자동차는 움직일 수 없습니다.");
        }

        for (Car car : cars) {
            car.move(NumberGenerator.createRandomNumbers());
        }

        referee.passedTime();
    }

    public List<Car> winners() {
        return cars.stream()
            .collect(Collectors.groupingBy(Car::getMovedCount, TreeMap::new, toList()))
            .lastEntry()
            .getValue();
    }

    public List<Car> getAllCars() {
        return cars;
    }

}
