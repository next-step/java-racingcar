package racingcar.policy;

import racingcar.domain.RandomNumber;

public interface MovePolicy {
    boolean canMove(RandomNumber randomNumber);
}
