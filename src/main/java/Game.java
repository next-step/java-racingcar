public class Game {

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }

    public void start() {
        GameSettings settings = InputView.getGameSettings();
        ResultView.presentStartMessage();

        Race race = new Race(settings);
        while (race.isRaceInProgress()) {
            ResultView.presentCars(race.getCarStatuses());
            race.runRound();
        }
        ResultView.presentCars(race.getCarStatuses());
        ResultView.presentWinners(race.getWinners());
    }
}
