package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGame {
    private RacingCar.RandomMoveGenerator moveNumberGenerator = null;
    private int times;
    private List<RacingCar> cars = null;

    private final int FINISH = 0;

    public RacingGame(int times, String[] carNames) {
        this.times = times;
        readyRacingCars(carNames);
        this.moveNumberGenerator = new RacingCar.RandomMoveGenerator();
    }

    private void readyRacingCars(String[] carNames) {
        cars = new ArrayList<>();
        for (String name: carNames) {
            cars.add(new RacingCar(name));
        }
    }

    public List<RacingCar> move() {
        validateGameDoing();
        moveCars();
        decreaseTimes();
        return cars;
    }

    private void validateGameDoing() {
        if (isFinish()) {
            throw new RacingGameException("RacingGame is over.");
        }
    }

    private void moveCars() {
        for (RacingCar car : cars) {
            int drivingForce = generateMoveNumber();
            car.move(drivingForce);
        }
    }

    public void setMoveNumberGenerator(RacingCar.RandomMoveGenerator moveNumberGenerator) {
        this.moveNumberGenerator = moveNumberGenerator;
    }

    public List<RacingCar> getResultOfTheGame() {
        return Collections.unmodifiableList(cars);
    }

    public boolean isFinish() {
        return times == FINISH;
    }

    private void decreaseTimes() {
        --times;
    }

    private int generateMoveNumber() {
        return moveNumberGenerator.generate();
    }
}