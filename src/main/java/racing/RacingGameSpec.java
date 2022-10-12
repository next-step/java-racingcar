package racing;

import util.RandomNumber;

public class RacingGameSpec {

    private static final int MOVE_THRESHOLD = 4;

    private RacingGameSpec() {}

    public static RacingGameSpec init() {
        return new RacingGameSpec();
    }

    public int moveCount() {
        final int RANDOM = RandomNumber.generate();
        return RANDOM >= MOVE_THRESHOLD ? 1 : 0;
    }
}
