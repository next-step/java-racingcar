package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> carList;

    public Cars(List<Car> cars) {
        this.carList = cars;
    }

    public static Cars fromCarNames(List<String> carNames) {
        List<Car> cars = carNames.stream().map(c -> new Car(c, new RandomMoveStrategy())).collect(Collectors.toList());
        return new Cars(cars);
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    public void round() {
        for (Car car : this.carList) {
            car.run();
        }
    }

    public List<String> getWinners() {
        List<String> winnerNames = new ArrayList<>();
        int maxPosition = getMaxPosition();
        for (Car car : this.carList) {
            saveWinnerName(car, maxPosition, winnerNames);
        }
        return winnerNames;
    }

    private static void saveWinnerName(Car car, int maxPosition, List<String> winnerNames) {
        if (car.comparePosition(maxPosition)) {
            winnerNames.add(car.getName());
        }
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : this.carList) {
            maxPosition = car.getMaxPosition(maxPosition);
        }
        return maxPosition;
    }
}
