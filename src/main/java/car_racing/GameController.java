package car_racing;

import car_racing.domain.RaceService;
import car_racing.view.model.UserInput;
import car_racing.view.UserInputService;

public class GameController {
    private final UserInputService userInputProcessor = new UserInputService();
    private final RaceService raceService = new RaceService();

    public void run() {
        UserInput userInput = userInputProcessor.getUserInput();
        raceService.race(userInput);
    }
}
