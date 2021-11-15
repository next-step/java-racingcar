package racing.model.mock;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MockRandom extends Random {

    private int nextValue = -1;

    /** 0 ~ (bound - 1) 까지 순차적으로 추출 */
    @Override
    public int nextInt(int bound) {
        nextValue = (nextValue + 1) % bound;
        return nextValue;
    }
}
