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
        CarRace race = new CarRace(carNames);
        int numberOfTrials = InputView.queryNumberOfTrials();

        for (int i = 0; i < numberOfTrials; i++) {
            race.round();
            ResultView.printRaceResult(race);
        }

        ResultView.printWinners(race.getWinners());
    }
}
