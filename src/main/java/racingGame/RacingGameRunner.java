package racingGame;

public class RacingGameRunner {

    public static void main(String[] args) {
        ResultView resultView = new ResultView();

        int numOfCars = InputView.inputGameValue(InputType.CAR);
        int move = InputView.inputGameValue(InputType.MOVE);

        RacingGame game = new RacingGame();
        game.initialize(numOfCars, move);

        while (game.hasNextRound()) {
            game.move();
            resultView.printRound(game.getCarsInGame());
        }
    }
}
