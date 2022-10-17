package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Winner {

    private final List<Car> cars;
    private List<String> winnerNames;

    public Winner(Cars cars) {
        this.cars = cars.getCarList();
        this.winnerNames = new ArrayList<>();
    }

    public List<String> compareWinner() {
        return maxPositionCar(compareMaxPosition());
    }
    private int compareMaxPosition() {
        Collections.sort(cars);
        return cars.get(0).getPosition();
    }

    private List<String> maxPositionCar(int maxPosition) {
        for (Car car : cars) {
            addWinner(maxPosition, car);
        }
        return winnerNames;
    }

    private void addWinner(int maxPosition, Car car) {
        if (maxPosition == car.getPosition()) {
            winnerNames.add(car.getName());
        }
    }
}
