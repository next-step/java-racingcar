package racingcargame;

public class Client {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        RandomOption randomOption = new RandomNumberOption();
        RacingCarGame racingCarGame = new RacingCarGame(inputView.inputNumberOfCars(), inputView.inputCount());
        inputView.scanner.close();
        resultView.showResultView();
        racingCarGame.startGame(randomOption);
    }
}