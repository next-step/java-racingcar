package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> value;

    public Cars(List<Car> value) {
        this.value = value;
    }

    public static Cars init(List<String> carNames) {
        List<Car> value = new ArrayList<>(carNames.size());

        for (String carName: carNames) {
            value.add(Car.create(carName, new SecureRandomPicker()));
        }

        return new Cars(value);
    }

    public List<String> game() {
        List<String> results = new ArrayList<>(value.size());

        for (Car car: value) {
            results.add(car.game().toString());
        }

        return results;
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
}
