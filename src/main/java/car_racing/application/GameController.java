package car_racing.application;

import car_racing.domain.service.RaceService;
import car_racing.domain.strategy.CarMovingStrategy;
import car_racing.domain.strategy.RandomMovingStrategy;
import car_racing.view.model.UserInput;
import car_racing.view.service.UserInputService;

public class GameController {
    private final UserInputService userInputProcessor = new UserInputService();
    private final RaceService raceService = new RaceService();
    private final CarMovingStrategy carMovingStrategy = new RandomMovingStrategy();

    public void run() {
        UserInput userInput = userInputProcessor.getUserInput();
        raceService.race(userInput, carMovingStrategy);
    }
}
