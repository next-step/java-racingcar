package step4;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        RacingGame racingGame;
        String[] inputName;

        inputView.init();

        do {
            inputView.showInputCarMessage();
            inputName = inputView.inputCarName();
        } while (inputView.isValidInput(inputName));

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
