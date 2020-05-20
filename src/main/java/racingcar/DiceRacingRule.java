package racingcar;

import racingcar.race.Dice;
import racingcar.race.RacingRule;

public class DiceRacingRule implements RacingRule {

    private static final int STOP_MOVE = 0;
    private static final int MOVE_FORWARD_COUNT = 1;
    private static final int STOP_MOVE_BOUNDS = 4;

    private final Dice dice;

    public DiceRacingRule(Dice dice) {
        this.dice = dice;
    }

    @Override
    public int getMoveForward() {
        int forwardCount = MOVE_FORWARD_COUNT;
        if(dice.generate() < STOP_MOVE_BOUNDS) {
            forwardCount = STOP_MOVE;
        }
        return forwardCount;
    }
}
