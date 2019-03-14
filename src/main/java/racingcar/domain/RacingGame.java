package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGame {
    private int time;
    private List<Car> cars = new ArrayList<>();

    public RacingGame(String[] carNames, int time) {
        for(String carName : carNames) {
            cars.add(new Car(carName, 1));
        }
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public List<Car> playRound() {
        cars.forEach(car -> {
            car.move(RandomCreator.createNewPosition());
        });
        return cars;
    }

    public List<Car> sortCars() {
        Collections.sort(cars);
        return cars;
    }
}
