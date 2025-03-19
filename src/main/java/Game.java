public class Game {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        GameSettings settings = inputView.getGameSettings();

        ResultView resultView = new ResultView();
        resultView.presentStartMessage();

        Race race = new Race(settings);
        while (race.isRaceInProgress()) {
            race.runRound();
            resultView.presentCars(race.getCarPositions());
        }
    }
}
