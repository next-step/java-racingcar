package stage4.service;

import stage4.domain.Car;
import stage4.domain.CarName;
import stage4.domain.Position;
import stage4.domain.RandomMovableStrategy;

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
            cars.add(new Car(new CarName(carName)));
        }
        return cars;
    }

    private List<Car> tryRacing(List<Car> cars) {
        List<Car> results = new ArrayList<>();
        for (Car car : cars) {
            car.tryForward(new RandomMovableStrategy());
            results.add(new Car(car));
        }
        return results;
    }

    public List<Car> checkWinner(List<Car> lastRacingResults) {
        List<Car> winners = new ArrayList<>();
        Position maxPosition = this.getMaxPosition(lastRacingResults);
        for (Car car : lastRacingResults) {
            if (car.isMaxPosition(maxPosition)) {
                winners.add(car);
            }
        }
        return winners;
    }

    private Position getMaxPosition(List<Car> resultValues) {
        Position max = new Position();
        for (Car resultValue : resultValues) {
            if (resultValue.getPosition().greaterThan(max)) { // todo getter
                max = resultValue.getPosition();
            }
        }
        return max;
    }
}