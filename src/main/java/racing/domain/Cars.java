package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public Cars movedAll(MovingStrategy movingStrategy) {
        List<Car> newCars = new ArrayList<>();
        for (Car car : cars) {
            newCars.add(carMove(car, movingStrategy));
        }
        return new Cars(newCars);
    }

    private Car carMove(Car car, MovingStrategy movingStrategy) {
        return car.move(movingStrategy);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> getWinner() {
        return collectWinners(seekMaxPosition());
    }

    private int seekMaxPosition() {
        int maxPosition = 0;

        for (Car car : cars) {
            maxPosition = car.max(maxPosition);
        }

        return maxPosition;
    }

    private List<Car> collectWinners(int maxPosition) {
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            car.addWinner(maxPosition, winners);
        }

        return winners;
    }
}
