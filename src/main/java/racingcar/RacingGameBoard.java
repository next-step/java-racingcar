package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGameBoard {

    private final int time;
    private final int numberOfCars;
    private final List<Car> cars;

    RacingGameBoard(int time, int numberOfCars) {
        this.time = time;
        this.numberOfCars = numberOfCars;
        this.cars = new ArrayList<>();
    }

    public void play() {
        for (int i = 0; i < numberOfCars; i++) {
            this.cars.add(new Car(Util.generateRandomNum(10)));
        }
    }

    public int getTime() {
        return time;
    }

    public List<Car> getCars() {
        return cars;
    }
}
