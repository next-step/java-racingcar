package racingGame;

public class RacingGameRunner {

    public static void main(String[] args) {
        String carNames = InputView.inputCarNames(InputType.CAR);
        int move = InputView.inputMove(InputType.MOVE);

        RacingGame game = new RacingGame(carNames, move);

        while (game.hasNextRound()) {
            game.move();
            ResultView.printRound(game.getCarsInGame());
        }

        ResultView.printWinners(GameResult.getWinners(game.getCarsInGame()));
    }
}
