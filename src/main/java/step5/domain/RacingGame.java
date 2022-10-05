package step5.domain;

import java.util.ArrayList;
import java.util.List;
import step5.util.CarFactory;

public class RacingGame {

    private final int MOVABLE_BOUNDARY = 3;
    private final List<Car> cars = new ArrayList<>();
    private final List<RacingResult> racingResults = new ArrayList<>();
    private final int tryCount;

    public RacingGame(String[] carNames, int tryCount){
        this.cars.addAll(CarFactory.createCar(carNames));
        this.tryCount = tryCount;
    }

    public List<RacingResult> start() {
        for (int i = 0; i < this.tryCount; i++) {
            playEachRound();
        }
        return racingResults;
    }

    private void playEachRound() {
        for (Car car : this.cars) {
            moveCar(car, isMovable());
            racingResults.add(new RacingResult(car));
        }
    }

    private static void moveCar(Car car, boolean isMovable) {
        if (isMovable) {
            car.moveForward();
        }
    }

    private boolean isMovable() {
        int randomNumber = RandomNumber.getRandomNumber();
        return randomNumber > MOVABLE_BOUNDARY;
    }

    public int getCarCount(){
        return this.cars.size();
    }
}
