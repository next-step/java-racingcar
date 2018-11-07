package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameReferee {

    private RacingGameReferee() {

    }

    public static List<RacingGameWinner> evaluate(List<RacingGameResultSet> resultSets) {
        RacingGameResultSet lastRacingGameResultSet = resultSets.get(resultSets.size() - 1);

        return lastRacingGameResultSet.getLeadingRacingGameResults().stream()
                .map(RacingGameWinner::of)
                .collect(Collectors.toList());
    }
}