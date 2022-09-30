package racinggame;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private static final int MIN_VALUE_OF_CAR_MOVE = 4;

    private final NumberGenerator numberGenerator;
    private final List<Car> cars;
    private final RacingGameResult result;

    public RacingGame(NumberGenerator numberGenerator, int numOfCar, int round) {
        this.numberGenerator = numberGenerator;
        this.cars = createCars(numOfCar);
        this.result = new RacingGameResult(round, numOfCar);
    }

    private List<Car> createCars(int numOfCar) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numOfCar; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    public RacingGameResult run() {
        for (int i = 0; i < result.getNumOfRound(); i++) {
            runRound(i);
        }
        return result;
    }

    private void runRound(int indexOfRound) {
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            moveCar(car);
            result.writeResult(indexOfRound, i, car.getPosition());
        }
    }

    private void moveCar(Car car) {
        if (isCarMovable()) {
            car.move();
        }
    }

    private boolean isCarMovable() {
        return numberGenerator.generateNumber() >= MIN_VALUE_OF_CAR_MOVE;
    }

}
