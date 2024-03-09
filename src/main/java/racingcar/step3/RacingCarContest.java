package racingcar.step3;

import racingcar.step3.move.MoveStrategy;
import racingcar.step3.print.PrintStrategy;

public class RacingCarContest {

    private final Round round;
    private final int roundsNumber;
    private final PrintStrategy printStrategy;

    public RacingCarContest(int carsNumber, int roundsNumber, MoveStrategy moveStrategy, PrintStrategy printStrategy) {
        this.round = new Round(moveStrategy, carsNumber);
        this.roundsNumber = roundsNumber;
        this.printStrategy = printStrategy;
    }

    public void startRacingContest() {
        for (int i = 0; i < roundsNumber; i++) {
            round.startRound();
            printCarsCurrentLocation();
            System.out.println();
        }
    }

    private void printCarsCurrentLocation() {
        printStrategy.printRoundResult(round.getCarsCurrentDistance());
    }
}
