package racinggame;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private static final int MIN_VALUE_OF_CAR_MOVE = 4;

    private final NumberGenerator numberGenerator;
    private final int numOfCar;
    private final int tryCount;
    private final List<Car> cars;
    private final int[][] result;


    public RacingGame(NumberGenerator numberGenerator, int numOfCar, int tryCount) {
        this.numberGenerator = numberGenerator;
        this.numOfCar = numOfCar;
        this.tryCount = tryCount;
        this.cars = createCars();
        this.result = new int[tryCount][numOfCar];
    }

    private List<Car> createCars() {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numOfCar; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    public int[][] run() {
        for (int i = 0; i < tryCount; i++) {
            writeOneTryResult(i);
        }
        return result;
    }

    private void writeOneTryResult(int index) {
        for (int j = 0; j < cars.size(); j++) {
            result[index][j] = getCarPosition(j);
        }
    }

    private int getCarPosition(int index) {
        Car car = cars.get(index);
        if (isCarMovable()) {
            car.move();
        }
        return car.getPosition();
    }

    private boolean isCarMovable() {
        return numberGenerator.generateNumber() >= MIN_VALUE_OF_CAR_MOVE;
    }

}
