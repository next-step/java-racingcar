package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Winner {

    private final List<Car> cars;
    private List<Car> winners;

    public Winner(Cars cars) {
        this.cars = cars.getCarList();
        this.winners = new ArrayList<>();
    }

    public List<Car> compareWinner() {
        return maxPositionCar(compareMaxPosition());
    }
    private int compareMaxPosition() {
        Collections.sort(cars);
        return cars.get(0).getPosition();
    }

    private List<Car> maxPositionCar(int maxPosition) {
        for (Car car : cars) {
            addWinner(maxPosition, car);
        }
        return winners;
    }

    private void addWinner(int maxPosition, Car car) {
        if (maxPosition == car.getPosition()) {
            winners.add(car);
        }
    }
}
