package racingcar.model;

import racingcar.policy.MovingPolicy;
import racingcar.policy.RandomMovingPolicy;

public class RacingGameSetting {
    private MovingPolicy movingPolicy;

    public RacingGameSetting(final MovingPolicy movingPolicy) {
        this.movingPolicy = settingMovingPolicy(movingPolicy);
    }

    private MovingPolicy settingMovingPolicy(MovingPolicy movingPolicy) {
        if (movingPolicy == null) {
            return new RandomMovingPolicy();
        }
        return movingPolicy;
    }

    public MovingPolicy getMovingPolicy() {
        return movingPolicy;
    }
}
