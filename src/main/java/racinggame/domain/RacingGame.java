package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

import static racinggame.domain.CarFactory.createCars;
import static racinggame.view.OutputView.getPositionDisplay;

public class RacingGame {

    private final List<Car> cars;
    private final int tryCount;

    public RacingGame(List<Car> cars, int tryCount) {
        this.cars = new ArrayList<>(cars);
        this.tryCount = tryCount;
    }

    public RacingGame(String carNames, int tryCount) {
        this(createCars(carNames), tryCount);
    }

    public void play() {
        System.out.println("실행 결과");

        for (int i = 0; i < tryCount; i++) {
            playRound();
            System.out.println();
        }
    }

    public void playRound() {
        for (Car car : cars) {
            car.move(generateRandomNumber());
            System.out.println(getPositionDisplay(car));
        }

    }

    private int generateRandomNumber() {
        return (int) (Math.random() * 10);
    }

    private int getMaxPosition() {
        int maxPosition = 0;

        for (Car car : cars) {
            maxPosition = car.compareAndReturnMax(maxPosition);
        }

        return maxPosition;
    }

    public Winners findWinners() {
        int maxPosition = getMaxPosition();
        List<String> winnerNames = cars.stream()
                .filter(car -> car.isWinnerWith(maxPosition))
                .map(Car::getName)
                .toList();
        return new Winners(winnerNames);
    }

    @Override
    public String toString() {
        return "RacingGame{" + "cars=" + cars + '}';
    }

}
