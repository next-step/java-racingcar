package racingcar.domain;

public class GameRole {
    private static final int ADVANCE_CONDITION = 4;

    private int advanceCount;

    public GameRole(int advanceCount) {
        this.advanceCount = advanceCount;
    }

    public int getAdvanceCount(int random) {
        return random >= ADVANCE_CONDITION ? advanceCount : 0;
    }
}
