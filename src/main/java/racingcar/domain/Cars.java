package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> value;

    private Cars(List<Car> value) {
        this.value = value;
    }

    public static Cars creatCarsByNames(List<String> carNames) {
        List<Car> value = new ArrayList<>(carNames.size());

        for (String carName: carNames) {
            value.add(Car.create(carName, new SecureRandomPicker()));
        }

        return new Cars(value);
    }

    public static Cars fromCars(List<Car> cars) {
        return new Cars(cars);
    }

    public void game() {
        for (Car car: value) {
            car.game();
        }
    }

    public List<String> winnerNames() {
        int maxGrade = maxGrade();
        List<String> winnerNames = new ArrayList<>();

        for (Car car: value) {
            addWinnerCar(car, maxGrade, winnerNames);
        }

        return winnerNames;
    }

    private void addWinnerCar(Car car, int maxGrade, List<String> winnerNames) {
        if (car.isWinner(maxGrade)) {
            winnerNames.add(car.name());
        }
    }

    private int maxGrade() {
        int maxGrade = Integer.MIN_VALUE;

        for (Car car: value) {
            maxGrade = Math.max(maxGrade, car.grade());
        }

        return maxGrade;
    }

    public List<String> carStatuses() {
        List<String> carStatus = new ArrayList<>(value.size());

        for (Car car: value) {
            carStatus.add(car.status());
        }

        return carStatus;
    }
}
