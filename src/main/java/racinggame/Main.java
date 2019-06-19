package racinggame;

public class Main {
    public static void main(String[] args) {
        InputView.displayCarInput();
        String carNameString = InputView.getNextString();

        InputView.displayRoundInput();
        int gameRound = InputView.getUserInputToInt();

        RacingGameParameters racingGameParameters = new RacingGameParameters(gameRound, carNameString);
        RacingGame racingGame = new RacingGame(racingGameParameters);

        GameResults gameResults = racingGame.playFullRound();


        ResultView.displayResult(gameResults);
    }
}
