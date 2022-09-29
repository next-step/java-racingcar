package racinggame;

public class Main {

    public static void main(String[] args) {
        int numOfCar = InputView.inputNumberOfCar();
        int tryCount = InputView.inputTryCount();
        RacingGame game = new RacingGame(new RandomNumberGenerator(), numOfCar, tryCount);
        RacingGameResult result = game.run();
        OutputView.printResult(result);
    }

}
