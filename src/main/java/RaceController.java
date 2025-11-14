import java.util.List;

public class RaceController {
    private final RaceGame game;
    private final int roundCount;

    public RaceController(List<Car> cars, int roundCount) {
        this.game = new RaceGame(cars);
        this.roundCount = roundCount;
    }

    public void start() {
        for (int round = 0; round < roundCount; round++) {
            playRound();
        }
        ResultView.printWinners(game.getWinners());
    }

    private void playRound() {
        game.race();
        ResultView.printResult(game.cars());
    }
}
