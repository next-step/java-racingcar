package racingcar.domain;

import racingcar.dto.RoundResult;
import racingcar.dto.RoundResults;

import java.util.ArrayList;
import java.util.List;

public class Rounds {
    private final List<Round> rounds;

    public Rounds(List<Round> rounds) {
        this.rounds = rounds;
    }

    public RoundResults play() {
        List<RoundResult> roundResults = new ArrayList<>();

        for (Round round : rounds) {
            roundResults.add(round.play());
        }

        return new RoundResults(roundResults);
    }

    public static Rounds fromCarsAndRoundsCounts(Cars cars, int roundCounts) {
        List<Round> rounds = new ArrayList<>();

        for (int i = 0; i < roundCounts; i++) {
            rounds.add(new Round(cars));
        }

        return new Rounds(rounds);
    }
}
