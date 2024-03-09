package racingcar.step3;

import java.util.Random;

public class RacingCarContest {

    private final Round round;
    private final int roundsNumber;
    private final Random random;

    public RacingCarContest(int carsNumber, int roundsNumber, Random random) {
        this.round = new Round(carsNumber);
        this.roundsNumber = roundsNumber;
        this.random = random;
    }

    public void startRacingContest() {
        for (int i = 0; i < roundsNumber; i++) {
            round.startRound(random);
            round.printRoundResult();
            System.out.println();
        }
    }
}
