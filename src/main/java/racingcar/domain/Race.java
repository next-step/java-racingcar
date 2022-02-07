package racingcar.domain;

import java.util.List;
import java.util.Random;
import racingcar.view.OutputView;

public class Race {

    private final Cars cars;
    private int times;

    public Race(List<String> carNames, int times) {
        this.cars = new Cars(carNames);
        this.times = times;
    }

    public void playGames() {
        while ((times--) > 0) {
            playGame();
            OutputView.printResult(cars.getCars());
        }
    }

    public void playGame() {
        for (Car car: cars.getCars()) {
            int randomNumber = getRandomNumber();
            car.moveCarRandomly(randomNumber);
        }
    }

    public int getRandomNumber() {
        return new Random().nextInt(10);
    }

    public List<Car> getFinalResult() {
        return cars.getCars();
    }
}
