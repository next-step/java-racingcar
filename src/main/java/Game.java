public class Game {

    private final InputView inputView;
    private final ResultView resultView;

    public Game(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public static void main(String[] args) {
        Game game = new Game(new InputView(), new ResultView());
        game.start();
    }

    public void start() {
        GameSettings settings = inputView.getGameSettings();
        resultView.presentStartMessage();

        Race race = new Race(settings);
        while (race.isRaceInProgress()) {
            resultView.presentCars(race.getCarStatuses());
            race.runRound();
        }
        resultView.presentCars(race.getCarStatuses());
        resultView.presentWinners(race.getWinners());
    }
}
