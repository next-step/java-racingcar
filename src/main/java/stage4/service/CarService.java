package stage4.service;

import stage4.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarService {

    public List<Car> startRace(String[] carNames, int numberOfTries) {
        final List<Car> cars = init(carNames);

        List<Car> results = new ArrayList<>();
        for (int i = 0; i < numberOfTries; i++) {
            results.addAll(this.tryRacing(cars));
        }
        return results;
    }

    private List<Car> init(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    private List<Car> tryRacing(List<Car> cars) {
        List<Car> results = new ArrayList<>();
        for (Car car : cars) {
            final int forwardCondition = car.getForwardCondition();
            car.tryForward(forwardCondition);
            results.add(new Car(car.getName(), car.getStatus()));
        }
        return results;
    }

    public List<Car> checkWinner(List<Car> lastRacingResults) {
        List<Car> winners = new ArrayList<>();
        int max = this.getMaxStatus(lastRacingResults);
        for (Car car : lastRacingResults) {
            this.checkMaxStatus(winners, max, car);
        }
        return winners;
    }

    private void checkMaxStatus(List<Car> winners, int max, Car car) {
        if (car.getStatus() == max) {
            winners.add(car);
        }
    }

    private int getMaxStatus(List<Car> resultValues) {
        int max = 0;
        for (Car resultValue : resultValues) {
            max = getMax(max, resultValue);
        }
        return max;
    }

    private int getMax(int max, Car resultValue) {
        if (resultValue.getStatus() > max) {
            max = resultValue.getStatus();
        }
        return max;
    }
}