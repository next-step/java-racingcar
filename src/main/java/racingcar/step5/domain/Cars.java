package racingcar.step5.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Cars {

    private static final String NAME_DELIMITER = ",";
    private List<Car> cars = new ArrayList<>();

    //테스트 코드를 위한 메서드
    public Cars(Car... car) {
        cars = Arrays.asList(car);
    }

    public Cars(String carName) {
        createCars(carName);
    }

    public void moveCars(MovingStrategy movingStrategy) {
        for (Car car : cars) {
            car.move(movingStrategy);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> findWinners() {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.isEqualPosition(getMaxPosition())) {
                winners.add(car);
            }
        }
        return winners;
    }

    public Position getMaxPosition() {
        Position maxPosition = new Position();
        for (Car car : cars) {
            maxPosition = car.getMaxPosition(maxPosition);
        }
        return maxPosition;
    }

    private void createCars(String carName) {
        Arrays.stream(carName.split(NAME_DELIMITER))
                .forEach(name -> cars.add(new Car(name.trim())));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

}
