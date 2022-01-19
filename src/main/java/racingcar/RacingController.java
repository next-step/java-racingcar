package racingcar;

import java.util.List;
import racingcar.domain.Participants;
import racingcar.domain.RacingResult;
import racingcar.domain.RandomManager;
import racingcar.domain.car.Car;

public class RacingController {

    private static final int BOUND = 4;
    private static String HEAD_MESSAGE = "\n실행 결과";
    private Participants participants;
    private final int turn;
    private final int totalCount;

    public RacingController(Participants participants, int turn) {
        this.participants = participants;
        this.turn = turn;
        totalCount = participants.getParticipantCount();
    }

    public static RacingController getInstance(Participants participants, int turn) {
        return new RacingController(participants, turn);
    }

    public void start() {
        System.out.println(HEAD_MESSAGE);
        RacingResult racingResult = RacingResult.getInstance(participants.getParticipants());
        for (int i = 0; i < turn; i++) {
            racingResult = race(racingResult);
            racingResult.getResultView();
        }
        racingResult.getWinner();
    }

    public RacingResult race(RacingResult result) {
        for (int i = 0; i < totalCount; i++) {
            if (RandomManager.get() >= BOUND) {
                participants.getParticipants().get(i).go();
            }
        }
        return RacingResult.getInstance(participants.getParticipants());
    }
}
