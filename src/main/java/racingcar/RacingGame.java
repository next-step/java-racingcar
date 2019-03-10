package racingcar;

import racingcar.random.PositiveIntUnder10Generator;
import racingcar.random.RandomIntGenerator;

import java.util.ArrayList;
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
        this.cars = new ArrayList<>(carNames.size());

        carNames.forEach(carName -> {
            this.cars.add(new Car(carName));
        });
    }

    public void start(int tryCount) {
        System.out.println("실행 결과\n");

        for (int i = 0; i < tryCount; i++) {
            runCars();
            printMovedDistanceOfCars();
            System.out.println();
        }
    }

    private void runCars() {
        this.cars.forEach(car -> {
            int randomInt = this.randomIntGenerator.getRandomInt();
            car.goWhenGreaterThanThreshold(randomInt);
        });
    }

    private void printMovedDistanceOfCars() {
        this.cars.forEach(Car::printMovedDistance);
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public List<Car> getWinners() {
        int maxMovedDistance = getMaxMovedDistanceOfCars();

        List<Car> winners = this.cars.stream()
                .filter(car -> maxMovedDistance == car.getMovedDistance())
                .collect(Collectors.toList());

        return winners;
    }

    private int getMaxMovedDistanceOfCars() {
        int maxMovedDistanceOfCars = this.cars.stream()
                .mapToInt(Car::getMovedDistance)
                .max()
                .getAsInt();

        return maxMovedDistanceOfCars;
    }
}