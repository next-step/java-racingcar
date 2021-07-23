package racingcar.domain.engine;

import java.util.Random;

public class CarEngine implements Engine {

    private static final Random RANDOM = new Random();

    private static final int INPUT_MAX = 10;

    @Override
    public int running() {
        return RANDOM.nextInt(INPUT_MAX);
    }
}
