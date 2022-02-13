package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import racingcar.view.OutputView;

public class Race {

    private final Cars cars;
    private int times;
    private final List<List<Car>> histories = new ArrayList<>();

    public Race(List<String> carNames, int times) {
        this.cars = new Cars(carNames);
        this.times = times;
    }

    public void playGames() {
        while ((times--) > 0) {
            playGame();
        }
        OutputView.printHistories(histories);
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
