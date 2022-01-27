package racingcar;

import racingcar.domain.Participants;
import racingcar.domain.RacingResult;

public class RacingController {

    private static final String HEAD_MESSAGE = "\n실행 결과";
    private Participants participants;
    private final int turnCount;

    private RacingController(Participants participants, int turn) {
        this.participants = participants;
        this.turnCount = turn;
    }

    public static RacingController getInstance(Participants participants, int turn) {
        return new RacingController(participants, turn);
    }

    public void start() {
        System.out.println(HEAD_MESSAGE);
        RacingResult racingResult = RacingResult.getInstance(participants.getParticipants());
        for (int i = 0; i < turnCount; i++) {
            racingResult = participants.race();
            racingResult.getResultView();
            participants = Participants.toParticipants(racingResult);
        }
        System.out.println(racingResult.getWinner());
    }
}
