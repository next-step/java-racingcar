package racing.domain;

import java.util.Random;

public class TestGameRule implements GameRule{
    private static final int INT_MAX = 10;
    private static final int INT_MIN = 4;
    private static final int POSSIBLE_INT = 4;

    @Override
    public int makeRandomInt() {
        return new Random().nextInt(INT_MAX - INT_MIN + 1);
    }

    @Override
    public int getPossibleInt() {
        return (POSSIBLE_INT <= (makeRandomInt() + INT_MIN) )? 1: 0;
    }
}
