package step3;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        RacingGame racingGame;

        inputView.init();
        inputView.showInputCarMessage();
        int carNumber = inputView.inputCarNumber();

        inputView.showInputRoundMessage();
        int round = inputView.inputRound();

        racingGame = new RacingGame(carNumber);

        resultView.showResultMessage();

        for (int i = 0; i < round; i++) {
            racingGame.playRace();
            resultView.printRace(racingGame.getCars());
        }
    }
}
