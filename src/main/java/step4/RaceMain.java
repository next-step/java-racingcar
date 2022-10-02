package step4;

import step4.domain.Race;
import step4.util.ConvertUtil;
import step4.view.InputView;
import step4.view.ResultView;

public class RaceMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        String carNames = inputView.askAndReceiveCarNames();
        int numOfRounds = inputView.askAndReceiveNumOfRounds();

        Race race = new Race();
        race.setUpRace(ConvertUtil.splitStringToArray(carNames));

        ResultView resultView = new ResultView();
        resultView.printRaceStart();

        for (int i = 0; i < numOfRounds; i++) {
            resultView.printEachRaceResult(race.runOneRound());
        }

        resultView.printWinners(race.getCars().getWinningCars());
    }
}
