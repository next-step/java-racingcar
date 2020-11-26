package step4;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        RacingGame racingGame;

        inputView.init();
        inputView.showInputCarMessage();
        String[] inputName;

        do {
            inputName = inputView.inputCarName();
        } while (inputView.isValidInput(inputName));

        inputView.showInputRoundMessage();
        int round = inputView.inputRound();

        racingGame = new RacingGame(inputName);

        resultView.showResultMessage();

        for (int i = 0; i < round; i++) {
            racingGame.playRace();
            resultView.printRace(racingGame.getCars());
        }

        resultView.printWinner(racingGame.getWinners());
    }
}
