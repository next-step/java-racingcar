package car_racing;

public class GameController {
    private final UserInputProcessor userInputProcessor = new UserInputProcessor();

    public void run() {
        UserInput userInput = userInputProcessor.getUserInput();
        CarController carController = new CarController(userInput);
        carController.race();
    }
}
