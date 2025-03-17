package racingcar.racing;

import racingcar.racing.model.Car;
import racingcar.racing.util.RandomGenerator;
import racingcar.racing.view.ResultView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCarGame {
    private static final int MAX_RANDOM_NUMBER = 10;
    private static final int MOVE_THRESHOLD = 4;

    private final RandomGenerator randomGenerator;
    private final List<Car> cars = new ArrayList<>();
    private final ResultView resultView;
    private int stage;

    public RacingCarGame(int carSize) {
        this(carSize, new RandomGenerator());
    }

    public RacingCarGame(int carSize, RandomGenerator randomGenerator) {
        this.stage = 0;
        this.resultView = new ResultView();
        this.randomGenerator = randomGenerator;

        init(carSize);
    }

    private void init(int carSize) {
        for (int i = 0; i < carSize; i++)
            this.cars.add(new Car());
    }

    public void process(int count) {
        for (int i = 0; i < count; i++)
            process();
    }

    private void process() {
        cars.forEach(this::moveCar);
        stage++;

        resultView.view(cars, stage);
    }

    private void moveCar(Car car) {
        int randomNumber = randomGenerator.generateRandomNumber(MAX_RANDOM_NUMBER);

        if (randomNumber >= MOVE_THRESHOLD)
            car.move();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public int getStage() {
        return stage;
    }
}
