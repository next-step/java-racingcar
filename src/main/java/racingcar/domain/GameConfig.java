package racingcar.domain;

import static racingcar.utils.IntegerUtils.*;


public class GameConfig {

    private final Participants participants;
    private final int maxOfRound;

    public GameConfig(Participants participants, int maxOfRound) {
        this.participants = participants;
        this.maxOfRound = isPositiveNumber(maxOfRound);
    }


    public Participants getParticipants() {
        return participants;
    }

    public int getMaxOfRound() {
        return maxOfRound;
    }

}
