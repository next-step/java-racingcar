package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private static final List<Car> cars = new ArrayList<>();
    private static final List<String> winners = new ArrayList<>();
    private int max = 0;

    public void createCar(String[] names) {
        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i]));
        }
    }

    public List<Car> startGame(RacingStrategy strategy) {
        cars.forEach(car -> car.moveOrStop(strategy));
        return cars;
    }

    public void calMaxPosition() {
        cars.forEach(car ->
           max = car.getMaxPosition(max));
    }

    public List<String> findWinner() {
        cars.forEach(car -> {
            if(car.isWinner(max)) {
                winners.add(car.getName());
            }
        });
        return winners;
    }
}
