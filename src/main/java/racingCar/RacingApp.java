package racingCar;

import racingCar.domain.Race;
import racingCar.domain.Round;
import racingCar.view.InputView;
import racingCar.view.ResultView;

public class RacingApp {

    InputView inputView = new InputView();
    ResultView resultView = new ResultView();

    public static void main(String[] args) {
        RacingApp app = new RacingApp();
        app.Race();
    }

    private void Race() {
        String nameList = this.inputView.EnterCarName();
        int moveCount = this.inputView.EnterMoveCount();
        this.inputView.closeScanner();

        Race race = new Race(nameList, moveCount);

        start(race);
        award(race);
    }

    private void start(Race race) {
        this.resultView.printExecutionResultMessage();
        int roundNumber = 1;

        while (race.isNotEnd(roundNumber)) {
            outputCarDistance(race.getRoundResult(roundNumber));
            roundNumber++;
        }
    }

    private void outputCarDistance(Round round) {
        int carCount = 0;
        while (round.isNotMaximum(carCount)) {
            this.resultView.printCarDistance(round.getCar(carCount));
            carCount++;
        }
        this.resultView.printEnter();
    }

    private void award(Race race) {
        resultView.printWinners(race.announceWinners());
    }

}
