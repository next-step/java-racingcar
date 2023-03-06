package racing.domain;

import java.util.Random;

public class RandomStadiumMoveOptionImpl implements StadiumMoveOption{

    private static final Random RANDOM = new Random();

    @Override
    public int getValue() {
        return RANDOM.nextInt(10);
    }
}
