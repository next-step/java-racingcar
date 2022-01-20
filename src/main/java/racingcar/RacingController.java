package racingcar;

import racingcar.domain.car.Move;
import racingcar.domain.Participants;
import racingcar.domain.RacingResult;

public class RacingController {

    private static final String HEAD_MESSAGE = "\n실행 결과";
    private Participants participants;
    private final int turnCount;
    private final int participantCount;
    private Move move;

    private RacingController(Participants participants, int turn) {
        this.participants = participants;
        this.turnCount = turn;
        this.move = Move.get();
        participantCount = participants.getParticipantCount();
    }

    public static RacingController getInstance(Participants participants, int turn) {
        return new RacingController(participants, turn);
    }

    public void start() {
        System.out.println(HEAD_MESSAGE);
        RacingResult racingResult = RacingResult.getInstance(participants.getParticipants());
        for (int i = 0; i < turnCount; i++) {
            racingResult = race(racingResult);
            racingResult.getResultView();
        }
        racingResult.getWinner();
    }

    public RacingResult race(RacingResult result) {
        for (int i = 0; i < participantCount; i++) {
            result.moveCarIfPositionChanged(i, move.isSatisfiedMoveCondition());
        }
        return result;
    }
}
