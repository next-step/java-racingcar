package racingcar;

import racingcar.rule.RacingRule;
import racingcar.rule.RandomRacingRule;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingRunner {

    private final InputView inputView = new InputView();

    private RacingCarDriver racingCarDriver;

    public void run() {
        this.racingCarDriver = this.inputView.inputParticipants();
        this.playRound(this.inputView.inputRacingRound());
        ResultView.printWinner(this.racingCarDriver);
    }

    /**
     * 주어진 회차만큼 진행합니다.
     * @param round
     */
    public void playRound(int round) {
        RacingRule racingRule = new RandomRacingRule();

        ResultView.printStartResult();
        for (int i = 0; i < round; i++) {
            this.racingCarDriver.moveForwardAll(racingRule);
            ResultView.printResultWithName(this.racingCarDriver);
            ResultView.printEndRound();
        }
    }

}
