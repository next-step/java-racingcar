package racingcar;

import java.util.List;

public class RacingGame {

    private int numberOfTry;
    private CarCollection cars;

    public RacingGame(int numberOfTry, int numberOfCars) {
        this.numberOfTry = numberOfTry;
        this.cars = new CarCollection(numberOfCars);
    }

    public List<List<Integer>> run() {
        drive();
        return cars.getResult();
    }

    public void drive() {
        for(int i=0; i<numberOfTry; i++) {
            cars.move();
        }
    }
}
