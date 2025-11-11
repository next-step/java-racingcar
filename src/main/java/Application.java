public class Application {
    public static void main(String[] args) {
        int carCount = InputView.readCarCountInput();
        int roundCount = InputView.readRoundCountInput();

        ResultView.printResultHeader();
        RaceGame game = new RaceGame(carCount, roundCount);
        game.execute();
    }
}
