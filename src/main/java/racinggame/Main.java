package racinggame;

public class Main {

    public static void main(String[] args) {
        int numOfCar = InputView.inputNumberOfCar();
        int tryCount = InputView.inputTryCount();
        RacingGame game = new RacingGame(new RandomNumberGenerator());
        RacingGameResult result = game.run(numOfCar, tryCount);
        OutputView.printResult(result);
    }

}
