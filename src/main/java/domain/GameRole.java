package domain;

import ui.ResultView;

import java.util.List;
import java.util.Random;

public class GameRole {

    private int numberOfAttempts;
    private List<Car> cars;
    private Random random;
    private ResultView resultView;


    public GameRole(int numberOfCars, int numberOfAttempts) {
        this.cars = CarFactory.createCars(numberOfCars);
        this.numberOfAttempts = numberOfAttempts;
        this.random = new Random();
        this.resultView = new ResultView();
    }

    public void playGame() {
        for (int i = 0; i < numberOfAttempts; i++) {
            for (Car car : cars) {
                int condition = random.nextInt(10);
                car.move(condition);
            }
        }

        printResult();
    }

    private void printResult() {
        resultView.printResult(cars, numberOfAttempts);
    }
}
