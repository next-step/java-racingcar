package racingGame;

public class RacingGameRunner {

    public static void main(String[] args) {
        int numOfCars = InputView.inputGameValue(InputType.CAR);
        int move = InputView.inputGameValue(InputType.MOVE);

        RacingGame game = new RacingGame(numOfCars, move);

        while (game.hasNextRound()) {
            game.move();
            ResultView.printRound(game.getCarsInGame());
        }
    }
}
