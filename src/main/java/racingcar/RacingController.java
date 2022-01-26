package racingcar;

import racingcar.domain.Participants;
import racingcar.domain.RacingRecord;
import racingcar.domain.RacingResult;

public class RacingController {

    private Participants participants;
    private final int turnCount;
    private final RacingRecord racingRecord;

    private RacingController(Participants participants, int turn) {
        this.participants = participants;
        this.turnCount = turn;
        racingRecord = RacingRecord.getInstance();
    }

    public static RacingController getInstance(Participants participants, int turn) {
        return new RacingController(participants, turn);
    }

    public RacingResult start() {
        RacingResult racingResult = RacingResult.getInstance(participants.getParticipants());
        for (int i = 0; i < turnCount; i++) {
            racingResult = participants.race();
            racingRecord.appendRecord(racingResult);
            participants = Participants.toParticipants(racingResult);
        }
        return racingResult;
    }

    public RacingRecord getRaceRecord() {
        return this.racingRecord;
    }
}
