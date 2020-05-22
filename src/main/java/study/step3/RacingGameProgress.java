package study.step3;

import java.util.ArrayList;
import java.util.List;

public class RacingGameProgress {
    private final static int INT_ONE = 1;

    public static List<Round> gameStart(RacingGame racingGame, CarMoveCondition moveCondition) {
        List<Round> rounds = new ArrayList<>();
        Round round = initRound(racingGame.getCarEntries());
        rounds.add(round);

        int tryTimes = racingGame.getTryTime();

        for (int i = INT_ONE; i < tryTimes; i++) {
            round = round.gameResult(moveCondition);
            rounds.add(round);
        }
        return rounds;
    }

    private static Round initRound(String [] carEntries) {
        return new Round(carEntries);
    }
}
