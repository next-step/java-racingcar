package car;

public class GameController {

    private static final InputParser inputParser = new InputParser();
    private final RacingGame racingGame;

    public GameController(RacingGame racingGame) {
        this.racingGame = racingGame;
    }

    public void startRacingGame() {
        Cars cars = new Cars(inputParser.parseUserInputByDelimiter(InputView.inputCarNames()));
        racingGame.playGame(InputView.inputNumberOfGames(), cars);
        ResultView.outputFinalGameResult(cars.findTiedWinnerCarNames());
    }
}
