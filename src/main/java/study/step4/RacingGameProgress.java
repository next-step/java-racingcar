package study.step4;

import java.util.ArrayList;
import java.util.List;

public class RacingGameProgress {
    private final static int INT_ZERO = 0;

    private final RacingGame racingGame;

    public RacingGameProgress(RacingGame racingGame) {
        this.racingGame = racingGame;
    }

    public List<Round> gameStart(CarMoveCondition moveCondition) {
        List<Round> rounds = new ArrayList<>();
        Round round = new Round(racingGame.getCarEntries());

        int tryTimes = racingGame.getTryTime();

        for (int i = INT_ZERO; i < tryTimes; i++) {
            round = round.carsRun(moveCondition);
            rounds.add(round);
        }
        return rounds;
    }
}
