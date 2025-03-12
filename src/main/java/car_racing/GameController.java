package car_racing;

public class GameController {
    private final UserInputProcessor userInputProcessor = new UserInputProcessor();

    public void run() {
        UserInput userInput = userInputProcessor.getUserInput();
        System.out.println("자동차 댓수 : " + userInput.getNumOfCar());
        System.out.println("게임의 횟수 : " + userInput.getNumOfGame());
    }
}
