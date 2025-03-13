package car_racing.domain;

import car_racing.view.model.UserInput;
import car_racing.view.UserInputProcessor;

public class GameController {
    private final UserInputProcessor userInputProcessor = new UserInputProcessor();

    public void run() {
        UserInput userInput = userInputProcessor.getUserInput();
        CarController carController = new CarController(userInput);
        carController.race();
    }
}
