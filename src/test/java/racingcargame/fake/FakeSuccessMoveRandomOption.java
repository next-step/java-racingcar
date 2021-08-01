package racingcargame.fake;

import racingcargame.RandomOption;

public class FakeSuccessMoveRandomOption implements RandomOption {

    @Override
    public int randomValue() {
        return 5;
    }
}
