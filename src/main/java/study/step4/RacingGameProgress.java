package study.step4;

import java.util.ArrayList;
import java.util.List;

public class RacingGameProgress {
    private final static int INT_ZERO = 0;

    private final RacingGame racingGame;

    public RacingGameProgress(RacingGame racingGame) {
        this.racingGame = racingGame;
    }

    public List<Round> progressRound(CarMoveCondition moveCondition) {
        List<Round> rounds = new ArrayList<>();
        Round round = new Round(racingGame.getCarEntries());
        int tryTimes = racingGame.getTryTime();

        for (int i = INT_ZERO; i < tryTimes; i++) {
            round = round.carsRun(moveCondition);
            rounds.add(round);
        }
        return rounds;
    }

    public RacingGameResult runGames(CarMoveCondition moveCondition){
        List<Round> roundResults = progressRound(moveCondition);
        Round lastRound = roundResults.get(roundResults.size() - 1);
        return new RacingGameResult(roundResults, lastRound.decideChampion());
    }
}
