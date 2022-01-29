package racingcar.domain.racing;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.car.Participants;

public class RacingGame {

    private final Participants participants;
    private final int turnCount;
    private final List<RacingResult> results;
    private final RacingRecord racingRecord;

    public RacingGame(Participants participants, int turnCount) {
        this.participants = participants;
        this.turnCount = turnCount;
        results = new ArrayList<>();
        this.racingRecord = new RacingRecord();
    }

    public void game() {
        for (int i = 0; i < turnCount; i++) {
            results.add(participants.race());
            racingRecord.appendRecord(results.get(i));
        }
    }

    public String getRacingProcess() {
        return racingRecord.getResultRecord();
    }

    public String getWinner() {
        return results.get(results.size() - 1).getWinner();
    }
}
