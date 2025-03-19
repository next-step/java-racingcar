package racingcar.racing;

import racingcar.racing.model.Car;
import racingcar.racing.util.RandomGenerator;
import racingcar.racing.view.ResultView;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {
    private static final int MAX_RANDOM_NUMBER = 10;
    private static final int MOVE_THRESHOLD = 4;

    private final RandomGenerator randomGenerator;
    private final List<Car> cars;
    private final ResultView resultView;
    private int stage;

    public RacingCarGame(List<String> carNames) {
        this(carNames, new RandomGenerator());
    }

    public RacingCarGame(List<String> carNames, RandomGenerator randomGenerator) {
        this.stage = 0;
        this.resultView = new ResultView();
        this.randomGenerator = randomGenerator;
        this.cars = carNames.stream().map(Car::new).collect(Collectors.toList());
    }

    public String playAndResult(int count) {
        process(count);

        int winnerPosition = cars.stream().mapToInt(Car::getPosition).max().getAsInt();

        return cars.stream().filter(car -> car.getPosition() == winnerPosition)
                .map(Car::getCarName)
                .collect(Collectors.joining(", ")) + "가 최종 우승했습니다.";
    }

    private void process(int count) {
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
