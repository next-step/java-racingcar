package carRacing.service;

import carRacing.domain.Car;
import carRacing.domain.Game;
import carRacing.domain.Judge;
import carRacing.domain.View;
import carRacing.dto.UserInput;

import java.util.List;

public class CarRacingService {

    private final View view = new View();
    private final Judge judge = new Judge();
    private final Game game = new Game();

    public void run(UserInput userInput, List<Car> cars) {
        view.declareRace();
        game.runRace(userInput, cars);
        view.printWinners(judge.findWinners(cars));
    }

}
