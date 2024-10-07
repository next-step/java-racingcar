package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Race {

    private List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public static Race fromCarNames(List<String> carNames) {
        List<Car> cars = carNames.stream().map(c -> new Car(c, new RandomMoveStrategy())).collect(Collectors.toList());
        return new Race(cars);
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void round() {
        for (Car car : this.cars) {
            car.run();
        }
    }

    public List<String> getWinners() {
        List<String> winnerNames = new ArrayList<>();
        int maxPosition = getMaxPosition();
        for (Car car : this.cars) {
            if (car.getPosition() == maxPosition) {
                winnerNames.add(car.getName());
            }
        }
        return winnerNames;
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : this.cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }
}
