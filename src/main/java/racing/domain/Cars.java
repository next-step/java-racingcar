package racing.domain;

import racing.util.NumberGenerator;
import racing.util.RandomNumberGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createCars(String[] carNames) {
        return new Cars(Arrays.stream(carNames)
                .map(name -> new Car(name, 0))
                .collect(Collectors.toList()));
    }

    public int getSize() {
        return this.cars.size();
    }

    public void tryMove() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        for (Car car : cars) {
            car.tryMove(numberGenerator.getInt());
        }
    }

    public void playRound() {
        this.tryMove();
    }

    public Car getCar(int index) {
        return cars.get(index);
    }

    private int getMasPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(car.getPosition(), maxPosition);
        }
        return maxPosition;
    }

    public Cars findWinners() {
        int maxPosition = getMasPosition();
        return new Cars(cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList()));
    }
}
