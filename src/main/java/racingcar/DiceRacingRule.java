package racingcar;

import racingcar.race.Dice;
import racingcar.race.RacingRule;

public class DiceRacingRule implements RacingRule {

    public static final int STOP_MOVE = 0;
    public static final int MOVE_FORWARD_COUNT = 1;

    private final Dice dice;

    public DiceRacingRule(Dice dice) {
        this.dice = dice;
    }

    @Override
    public int getMoveForward() {
        int forwardCount = MOVE_FORWARD_COUNT;
        if(dice.generate() < 4) {
            forwardCount = STOP_MOVE;
        }
        return forwardCount;
    }
}
