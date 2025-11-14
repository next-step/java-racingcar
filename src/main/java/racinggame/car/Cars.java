package racinggame.car;

import static java.util.Collections.unmodifiableList;
import static racinggame.RandomNumberBox.getRandomNumber;
import static racinggame.utils.StringUtils.splitToList;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        List<Car> carList = new ArrayList<>(carNames.size());

        for (String carName : carNames) {
            carList.add(
                    new Car(carName)
            );
        }

        this.cars = carList;
    }

    public int size() {
        return this.cars.size();
    }

    public int findMaxPositions() {
        return 0;
    }

    public List<String> findWinners(int maxPositions) {
        return new ArrayList<>();
    }

    public List<Car> getCars() {
        return unmodifiableList(cars);
    }
}
