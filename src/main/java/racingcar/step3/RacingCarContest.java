package racingcar.step3;

import racingcar.step3.move.MoveStrategy;
import racingcar.step3.print.PrintStrategy;

import java.util.Random;

public class RacingCarContest {

    private final Round round;
    private final int roundsNumber;

    public RacingCarContest(int carsNumber, int roundsNumber, MoveStrategy moveStrategy, PrintStrategy printStrategy) {
        this.round = new Round(moveStrategy, carsNumber, printStrategy);
        this.roundsNumber = roundsNumber;
    }

    public void startRacingContest() {
        for (int i = 0; i < roundsNumber; i++) {
            round.startRound();
            round.printRoundResult();
            System.out.println();
        }
    }
}
