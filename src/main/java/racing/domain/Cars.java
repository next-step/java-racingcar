package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars create(List<String> carNames) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            carList.add(car);
        }
        return new Cars(carList);
    }

    public Cars move(MovingStrategy movingStrategy) {
        List<Car> newCars = new ArrayList<>();
        for (Car car : cars) {
            newCars.add(car.move(movingStrategy));
        }
        return new Cars(newCars);
    }

    public List<Car> getCarList() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> findWinners() {
        return collectWinners(seekMaxPosition());
    }

    private Position seekMaxPosition() {
        Position maxPosition = new Position();

        for (Car car : cars) {
            maxPosition = car.getBetterPosition(maxPosition);
        }

        return maxPosition;
    }

    private List<Car> collectWinners(Position maxPosition) {
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            car.addWinner(maxPosition, winners);
        }

        return winners;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Cars)) {
            return false;
        }

        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cars);
    }
}
