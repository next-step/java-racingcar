package racingcar;

import racingcar.rule.RacingRule;
import racingcar.rule.RandomRacingRule;

public class RacingRunner {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    private RacingCarDriver racingCarDriver;

    public void run() {
        this.racingCarDriver = this.inputView.inputParticipants();
        this.playRound(this.inputView.inputRacingRound());
        this.resultView.printWinner(this.racingCarDriver);
    }

    /**
     * 주어진 회차만큼 진행합니다.
     * @param round
     */
    public void playRound(int round) {
        RacingRule racingRule = new RandomRacingRule();

        this.resultView.printStartResult();
        for (int i = 0; i < round; i++) {
            this.racingCarDriver.moveForwardAll(racingRule);
            this.resultView.printResultWithName(this.racingCarDriver);
            this.resultView.printEndRound();
        }
    }

}
