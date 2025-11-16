public class RaceController {
    private final RaceGame game;
    private final RoundCount roundCount;

    public RaceController(Cars cars, int roundCount) {
        this(new RaceGame(cars), new RoundCount(roundCount));
    }

    public RaceController(RaceGame game, RoundCount roundCount) {
        this.game = game;
        this.roundCount = roundCount;
    }

    public void start() {
        ResultView.printResultHeader();
        for (int round = 0; round < roundCount.count(); round++) {
            playRound();
        }
        ResultView.printWinners(game.getWinners());
    }

    private void playRound() {
        game.race();
        ResultView.printResult(game);
    }
}
