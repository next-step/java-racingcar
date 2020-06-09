package study.nextstep.stage5.domain;

import java.util.Random;

public class Position {
    private static final int THRESHOLD_CAR_MOVE_RANDOM_VAL = 4;
    private static final int CAR_MOVE_RANDOM_LIMIT_VAL = 10;

    private String name;
    private int position;

    public Position(String name) {
        this.name = name;
        position = 1;
    }

    public String getName() {
        return name;
    }

    public void run(Random randomModule) {
        if (randomModule.nextInt(CAR_MOVE_RANDOM_LIMIT_VAL) >= THRESHOLD_CAR_MOVE_RANDOM_VAL) {
            position++;
        }
    }

    public String renderPosition(String renderCharacter) {
        return String.format("%s : %s\n", name, renderCharacter.repeat(position));
    }

    public Position compareWinner(Position winner) {
        if (winner == null) {
            return this;
        }
        return this.position > winner.position ? this : winner;
    }

    public boolean isWinner(Position status) {
        return status != null && status.position == position;
    }

}
