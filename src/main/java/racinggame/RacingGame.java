package racinggame;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private static final int MIN_VALUE_OF_CAR_MOVE = 4;

    private final NumberGenerator numberGenerator;
    private final int numOfCar;
    private final int round;
    private final List<Car> cars;
    private final int[][] result;

    public RacingGame(NumberGenerator numberGenerator, int numOfCar, int round) {
        this.numberGenerator = numberGenerator;
        this.numOfCar = numOfCar;
        this.round = round;
        this.cars = createCars();
        this.result = new int[round][numOfCar];
    }

    private List<Car> createCars() {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numOfCar; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    public int[][] run() {
        for (int i = 0; i < round; i++) {
            runRound(i);
        }
        return result;
    }

    private void runRound(int indexOfRound) {
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            moveCar(car);
            result[indexOfRound][i] = car.getPosition();
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
