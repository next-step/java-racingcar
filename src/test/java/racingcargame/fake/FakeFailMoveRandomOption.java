package racingcargame.fake;

import racingcargame.RandomOption;

public class FakeFailMoveRandomOption implements RandomOption {

    @Override
    public int randomValue() {
        return 1;
    }
}
