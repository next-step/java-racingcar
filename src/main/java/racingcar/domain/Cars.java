package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> createCar(String[] names) {
        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i]));
        }
        return cars;
    }

    public List<Car> startGame(RacingStrategy strategy) {
        cars.forEach(car -> car.moveOrStop(strategy));
        return cars;
    }

    public int calMaxPosition() {
        int maxValue = 0;
        for (Car car : cars) {
            maxValue = car.getMaxPosition(maxValue);
        }
        return maxValue;
    }

    public List<String> findWinner() {
        int max = calMaxPosition();
        List<String> winners = new ArrayList<>();
        cars.forEach(car -> {
            if (car.isWinner(max)) {
                winners.add(car.getName());
            }
        });
        return winners;
    }

}
