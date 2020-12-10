package racingcar;

import racingcar.rule.RacingRule;
import racingcar.rule.RandomRacingRule;

import java.util.Scanner;

public class RacingRunner {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    private RacingCarDriver racingCarController;

    public void run() {
        this.racingCarController = this.inputView.inputCarAmount();
        this.playRound(this.inputView.inputRacingRound());
    }


    /**
     * 주어진 회차만큼 진행합니다.
     * @param round
     */
    public void playRound(int round) {
        RacingRule racingRule = new RandomRacingRule();

        System.out.println("실행 결과");
        for (int i = 0; i < round; i++) {
            this.racingCarController.moveForwardAll(racingRule);
            this.resultView.printResult(this.racingCarController);
            System.out.println();
        }
    }

}
