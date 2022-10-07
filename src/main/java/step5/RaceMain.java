package step5;

import step5.domain.Race;
import step5.util.ConvertUtil;
import step5.view.InputView;
import step5.view.ResultView;

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

        resultView.printWinners(race.getWinnersNames());
    }
}
