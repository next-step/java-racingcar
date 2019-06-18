package racinggame;

public class Main {
    public static void main(String[] args) {
        InputView.displayCarInput();
        int carQuantity = InputView.getUserInputToInt();

        InputView.displayRoundInput();
        int gameRound = InputView.getUserInputToInt();

        RacingGameParameters racingGameParameters = new RacingGameParameters(gameRound, carQuantity);
        RacingGame racingGame = new RacingGame(racingGameParameters);

        GameResults gameResults = racingGame.playFullRound();


        ResultView.displayResult(gameResults);
    }
}
