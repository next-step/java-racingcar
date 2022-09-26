package racing;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final List<Car> cars;
    private final List<List<Integer>> racingResult;
    private final int numberOfAttempts;

    public RacingGame(int numberOfCars, int numberOfAttempts) {
        this.racingResult = new ArrayList<>();
        this.cars = new ArrayList<>();
        this.numberOfAttempts = numberOfAttempts - 1;
        runZeroRound(numberOfCars);
    }

    public List<List<Integer>> run() {
        runRacing();
        return racingResult;
    }

    private void runZeroRound(int numberOfCars) {
        addCars(numberOfCars);
        saveRoundResult();
    }

    private void addCars(int numberOfCars) {
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car(new PositiveRandomNumber()));
        }
    }

    private void runRacing() {
        for (int i = 0; i < numberOfAttempts; i++) {
            runRound();
            saveRoundResult();
        }
    }

    private void saveRoundResult() {
        racingResult.add(roundResult());
    }

    private List<Integer> roundResult() {
        return addAllCarsRoundResult(new ArrayList<>());
    }

    private List<Integer> addAllCarsRoundResult(List<Integer> roundResult) {
        for (Car car : cars) {
            roundResult.add(carRoundResult(car));
        }
        return roundResult;
    }

    private int carRoundResult(Car car) {
        return car.currentPosition();
    }

    private void runRound() {
        for (Car car : cars) {
            car.move();
        }
    }
}
