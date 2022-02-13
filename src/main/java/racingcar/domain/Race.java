package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Race {

    private final Cars cars;
    private int times;
    private final List<List<Car>> histories = new ArrayList<>();

    public Race(Cars cars, int times) {
        this.cars = cars;
        this.times = times;
    }

    public List<List<Car>> playGames() {
        while ((times--) > 0) {
            playGame();
        }
        return histories;
    }

    public void playGame() {
        List<Car> history = new ArrayList<>();
        for (Car car: cars.getCars()) {
            car.moveCarRandomly(getRandomNumber());
            history.add(new Car(car.getName(), car.getDistance()));
        }
        histories.add(history);
    }

    public int getRandomNumber() {
        return new Random().nextInt(10);
    }

    public Cars getFinalResult() {
        return cars;
    }
}
