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
        int trialNumber = InputView.queryTrialNumber();

        CarRace race = new CarRace(carNames, trialNumber);
        race.startRace(ResultView::printCars);

        ResultView.printWinners(race.getWinners());
    }
}
