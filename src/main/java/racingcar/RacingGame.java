package racingcar;

import racingcar.random.PositiveIntUnder10Generator;
import racingcar.random.RandomIntGenerator;
import racingcar.ui.RacingGameOutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private List<Car> cars;
    private RandomIntGenerator randomIntGenerator;

    public RacingGame(List<String> carNames) {
        this(carNames, new PositiveIntUnder10Generator());
    }

    public RacingGame(List<String> carNames, RandomIntGenerator randomIntGenerator) {
        carSetUp(carNames);
        this.randomIntGenerator = randomIntGenerator;
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

        List<Car> winners = getWinners();
        RacingGameOutputView.printWinners(winners);
    }

    private void runCars() {
        this.cars.forEach(car -> {
            int randomInt = this.randomIntGenerator.getRandomInt();
            car.goWhenGreaterThanThreshold(randomInt);
        });
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public List<Car> getWinners() {
        int maxMovedDistance = getMaxMovedDistanceOfCars();

        return this.cars.stream()
                .filter(car -> maxMovedDistance == car.getMovedDistance())
                .collect(Collectors.toList());
    }

    private int getMaxMovedDistanceOfCars() {
        return this.cars.stream()
                .mapToInt(Car::getMovedDistance)
                .max()
                .getAsInt();
    }
}