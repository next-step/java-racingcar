package step3.app;

import step3.factory.CarFactory;
import step3.input.InputView;
import step3.model.Car;
import step3.output.ResultView;
import step3.service.CarRacingGame;

import java.util.List;
import java.util.Map;

public class CarRacingGameApp {

    public static void main(String[] args) {
        Map<String, Integer> configuration = InputView.getConfiguration();
        int numberOfCars = configuration.get("numberOfCars");
        int numberOfAttempts = configuration.get("numberOfAttempts");
        List<Car> cars = CarFactory.create(numberOfCars);
        CarRacingGame carRacingGame = new CarRacingGame(cars, numberOfAttempts);
        carRacingGame.start();
        ResultView.printResult();
    }

}
