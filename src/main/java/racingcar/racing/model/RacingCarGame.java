package racingcar.racing.model;

import racingcar.racing.util.RandomGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {
    private static final int MAX_RANDOM_NUMBER = 10;
    private static final int MOVE_THRESHOLD = 4;

    private final RandomGenerator randomGenerator;
    private final List<Car> cars;
    private int stage;

    public RacingCarGame(List<String> carNames) {
        this(carNames, new RandomGenerator());
    }

    public RacingCarGame(List<String> carNames, RandomGenerator randomGenerator) {
        this.stage = 0;
        this.randomGenerator = randomGenerator;
        this.cars = carNames.stream().map(Car::new).collect(Collectors.toList());
    }

    public List<String> getCurrentStageWinner() {
        int winnerPosition = cars.stream().mapToInt(Car::getPosition).max().getAsInt();

        return cars.stream().filter(car -> car.getPosition() == winnerPosition)
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    public void process(int count) {
        for (int i = 0; i < count; i++)
            process();
    }

    public void process() {
        cars.forEach(this::moveCar);
        stage++;
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
