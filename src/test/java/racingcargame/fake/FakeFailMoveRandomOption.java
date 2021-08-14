package racingcargame.fake;

import racingcargame.domain.RandomOption;

public class FakeFailMoveRandomOption implements RandomOption {

    @Override
    public int randomValue() {
        return 1;
    }
}
