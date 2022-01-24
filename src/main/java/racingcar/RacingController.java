package racingcar;

import racingcar.domain.car.Move;
import racingcar.domain.Participants;
import racingcar.domain.RacingResult;
import racingcar.domain.random.RandomGenerator;

public class RacingController {

    private static final String HEAD_MESSAGE = "\n실행 결과";
    private Participants participants;
    private final int turnCount;
    private Move move;

    public RacingController(Participants participants, int turn) {
        this.participants = participants;
        this.turnCount = turn;
        this.move = new Move();
    }

    public void start() {
        System.out.println(HEAD_MESSAGE);
        RacingResult racingResult = new RacingResult(participants);
        for (int i = 0; i < turnCount; i++) {
            racingResult = race(racingResult);
            racingResult.getResultView();
        }
        racingResult.printWinners();
    }

    public RacingResult race(RacingResult result) {
        for (int i = 0; i < participants.count(); i++) {
            result.moveCarIfPositionChanged(i,
                move.isSatisfiedMoveCondition(new RandomGenerator()));
        }
        return result;
    }
}
