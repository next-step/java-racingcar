package step4;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        RacingGame racingGame;

        inputView.init();
        inputView.showInputCarMessage();
        String[] inputName = inputView.inputCarName();

        inputView.showInputRoundMessage();
        int round = inputView.inputRound();

        racingGame = new RacingGame(inputName, round);

        racingGame.playGame();
    }
}
