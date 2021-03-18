package carRacing.service;

import carRacing.domain.Car;
import carRacing.domain.CarFactory;
import carRacing.domain.Game;
import carRacing.domain.Judge;
import carRacing.dto.UserInput;
import carRacing.view.View;

import java.util.List;

public class CarRacingService {

    private final CarFactory carFactory = new CarFactory();
    private final View view = new View();
    private final Judge judge = new Judge();
    private final Game game = new Game();

    public void run() {
        UserInput userInput = view.getUserInput();
        List<Car> cars = carFactory.initCars(userInput);
        view.declareRace();
        cars = game.runRace(userInput, cars);
        view.printHistory(cars);
        view.printWinners(judge.findWinners(cars));
    }

}
