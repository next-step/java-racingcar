package step3.app;

import step3.factory.CarFactory;
import step3.input.InputView;
import step3.model.Car;
import step3.output.ResultView;
import step3.service.CarRacingGame;

import java.util.List;

public class CarRacingGameApp {

    public static void main(String[] args) {
        int numberOfCars = InputView.getNumberOfCars();
        int numberOfAttempts = InputView.getNumberOfAttempts();
        List<Car> cars = CarFactory.create(numberOfCars);
        CarRacingGame carRacingGame = new CarRacingGame(cars, numberOfAttempts);
        carRacingGame.start();
        ResultView.printResult();
    }

}
