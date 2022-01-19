package racingcar;

import racingcar.domain.Participants;

public class RacingController {

    private Participants participants;
    private final int turn;

    public RacingController(Participants participants, int turn) {
        this.participants = participants;
        this.turn = turn;
    }

    public static RacingController getInstance(Participants participants, int turn) {
        return new RacingController(participants, turn);
    }

    public void start() {
        for (int i = 0; i < turn; i++) {
            race();
        }
    }
    public void race() {
        // do race
    }
}
