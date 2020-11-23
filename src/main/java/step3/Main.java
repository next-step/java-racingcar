package step3;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        inputView.init();
        inputView.showInputCarMessage();
        int carNumber = inputView.inputCarNumber();

        inputView.showInputRoundMessage();
        int round = inputView.inputRound();

        RacingGame racingGame = new RacingGame(carNumber, round);

        racingGame.playGame(round);
    }
}
