package step3;

import step3.domain.Race;
import step3.view.InputView;
import step3.view.ResultView;

public class RaceMain {

    public static void main(String[] args) {
        receiveRaceInputs();
    }

    private static void receiveRaceInputs() {
        InputView inputView = new InputView();
        int numOfCars = inputView.askAndReceiveNumOfCars();
        int numOfRounds = inputView.askAndReceiveNumOfRounds();

        setUpRace(numOfCars, numOfRounds);
    }

    private static void setUpRace(int numOfCars, int numOfRounds) {
        Race race = new Race();
        race.setUpRace(numOfCars, numOfRounds);
        startRace(race);
    }

    private static void startRace(Race race) {
        ResultView resultView = new ResultView();
        resultView.printRaceStart();

        for (int i = 0; i < race.getNumOfRounds(); i++) {
            race.runOneRound();
            resultView.printEachRaceResult(race.getCars());
        }
    }

}
