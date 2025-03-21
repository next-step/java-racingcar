package edu.nextstep.camp.carracing.domain;

import edu.nextstep.camp.carracing.view.ResultView;

import java.util.ArrayList;
import java.util.List;

import static edu.nextstep.camp.carracing.util.RandomNumberGenerator.generateRandomNumber;

public class Cars {
    private final List<Car> values;

    public Cars(List<Car> cars) {
        this.values = cars;
    }

    public static Cars fromNames(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return new Cars(cars);
    }

    public void moveCars() {
        for (Car car : this.values) {
            car.move(generateRandomNumber());
        }
    }

    public void printCarStatus() {
        for (Car car : this.values) {
            ResultView.printCarStatus(car);
        }
        ResultView.printLine();
    }

    public int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : this.values) {
            maxPosition = car.getMaxValue(maxPosition);
        }
        return maxPosition;
    }

    public Cars getWinners() {
        int winnerPosition = getMaxPosition();
        List<String> result = new ArrayList<>();
        for (Car car : this.values) {
            if (car.isMaxPosition(winnerPosition)) {
                result.add(car.getName().getName());
            }
        }
        return Cars.fromNames(result);
    }

    public List<String> getWinnerNames() {
        List<String> result = new ArrayList<>();
        for (Car value : this.values) {
            if (value.isMaxPosition(getMaxPosition())) {
                result.add(value.getName().getName());
            }
        }
        return result;
    }
}
