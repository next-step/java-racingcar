package carrace;

public class Race {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        CarRace carRace = inputView.makeCarRaceByInput();
        carRace.startRaces();

        ResultView resultView = new ResultView();
        resultView.printCarRaceResult(carRace);
    }
}
