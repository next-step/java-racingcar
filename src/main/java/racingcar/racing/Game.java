package racingcar.racing;

import racingcar.racing.model.Car;
import racingcar.racing.util.RandomGenerator;
import racingcar.racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Car> cars = new ArrayList<>();
    private final ResultView resultView;
    private int stage;

    public Game(int carSize) {
        this.stage = 0;
        this.resultView = new ResultView();

        init(carSize);
    }

    private void init(int carSize) {
        for (int i = 0; i < carSize; i++)
            this.cars.add(new Car());
    }

    public void start() {
        cars.forEach(this::moveCar);
        stage++;

        resultView.view(cars, stage);
    }

    private void moveCar(Car car) {
        int randomNumber = RandomGenerator.generateRandomNumber(10);

        if (randomNumber >= 4)
            car.move();
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getStage() {
        return stage;
    }
}
