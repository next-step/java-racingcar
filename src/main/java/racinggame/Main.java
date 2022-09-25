package racinggame;

public class Main {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        int numOfCar = inputView.inputNumberOfCar();
        int tryCount = inputView.inputTryCount();
        RacingGame game = new RacingGame(new RandomNumberGenerator(), numOfCar, tryCount);
        int[][] result = game.run();
        outputView.printResult(result);
    }

}
