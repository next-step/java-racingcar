package racing.module;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarGame {
    private static final String CARNAME_DELIMITER = ",";
    private final List<Car> carList = new ArrayList<>();

    public CarGame(String carName) {
        String[] names = carName.split(CARNAME_DELIMITER);

        for (String name : names) {
            carList.add(new Car(name));
        }
    }

    public void play(MoveStrategy strategy) {
        for (Car car : carList) {
            car.attempt(strategy);
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<Car> getWinner() {
        return carList.stream()
                .filter(car -> car.checkPosition(getMaxPosition()))
                .collect(Collectors.toList());
    }

    public int getMaxPosition() {
        return carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow();
    }
}
