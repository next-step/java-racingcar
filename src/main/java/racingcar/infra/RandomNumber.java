package racingcar.infra;

import racingcar.domain.Number;

import java.util.Random;

public class RandomNumber implements Number {

    private final Random random = new Random();

    @Override
    public int generate() {
        return random.nextInt(10);
    }
}
