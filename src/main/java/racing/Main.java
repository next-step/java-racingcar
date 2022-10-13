package racing;

public class Main {
    public static void main(String[] args) {
        try {
            doMain();
        } catch (Exception e) {
            ResultView.printError(e);
        }
    }

    private static void doMain() {
        String[] carNames = InputView.queryCarNames();
        int numberOfTrials = InputView.queryNumberOfTrials();

        CarRace race = new CarRace(carNames, numberOfTrials);
        race.startRace(ResultView::printCars);

        ResultView.printWinners(race.getWinners());
    }
}
