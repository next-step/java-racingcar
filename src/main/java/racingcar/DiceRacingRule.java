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
        if(dice.generate() < STOP_MOVE_BOUNDS) {
            return STOP_MOVE;
        }
        return MOVE_FORWARD_COUNT;
    }
}
