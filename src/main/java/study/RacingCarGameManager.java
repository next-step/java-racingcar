package study;

public class RacingCarGameManager {
    public static void main(String[] args) {
        InputView numberOfCar = new InputView("자동차 대수는 몇 대 인가요?");
        numberOfCar.displayMessage();
        numberOfCar.getUserInput();

        InputView numberOfRound = new InputView("시도할 회수는 몇 회 인가요?");
        numberOfRound.displayMessage();
        numberOfRound.getUserInput();

        RacingCarGame game = new RacingCarGame(numberOfCar.getCounts(), numberOfRound.getCounts());
        game.run();

        ResultView resultView = new ResultView();
        resultView.displayResult(game);
    }
}
