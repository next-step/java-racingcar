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

        Race race = new Race(nameList, moveCount);

        start(race);
    }

    private void start(Race race) {
        this.resultView.printExecutionResultMessage();
        int roundCount = race.getRoundCount();

        for(int i = 1; i < roundCount; i++) {
            outputCarDistance(race.getRoundResult(i));
        }
    }

    private void outputCarDistance(Round round) {
        int carCount = round.getCarsSize();

        for(int i = 0; i < carCount; i++) {
            this.resultView.printCarDistance(round.getCar(i));
        }
        this.resultView.printEnter();
    }

}
