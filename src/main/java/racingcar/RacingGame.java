package racingcar;

import racingcar.random.PositiveIntUnder10Generator;
import racingcar.random.RandomIntGenerator;
import racingcar.ui.RacingGameOutputView;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private List<Car> cars;
    private RandomIntGenerator randomIntGenerator;
    private RacingGameJudge judge;

    public RacingGame(List<String> carNames) {
        this(carNames, new PositiveIntUnder10Generator());
    }

    public RacingGame(List<String> carNames, RandomIntGenerator randomIntGenerator) {
        carSetUp(carNames);
        this.randomIntGenerator = randomIntGenerator;
        this.judge = new RacingGameJudge();
    }

    private void carSetUp(List<String> carNames) {
        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void start(int tryCount) {
        System.out.println("실행 결과\n");

        for (int i = 0; i < tryCount; i++) {
            runCars();
            RacingGameOutputView.printMovedDistanceOfCars(this.cars);
            RacingGameOutputView.printEmptyLine();
        }

        List<Car> winners = judge.getWinners(this.cars);
        RacingGameOutputView.printWinners(winners);
    }

    private void runCars() {
        this.cars.forEach(car -> {
            int randomInt = this.randomIntGenerator.getRandomInt();
            car.goWhenGreaterThanThreshold(randomInt);
        });
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(this.cars);
    }
}