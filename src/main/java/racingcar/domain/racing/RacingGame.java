package racingcar.domain.racing;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.car.Participants;

public class RacingGame {

    private final Participants participants;
    private final int turnCount;

    public RacingGame(Participants participants, int turnCount) {
        this.participants = participants;
        this.turnCount = turnCount;
    }

    public List<RacingResult> gameStart(RacingRecord racingRecord) {
        List<RacingResult> results = new ArrayList<>();
        for (int i = 0; i < turnCount; i++) {
            results.add(participants.race());
            racingRecord.appendRecord(results.get(i));
        }
        return results;
    }
}
