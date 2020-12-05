package racing.domain;

import java.util.Random;

public class RandomPowerGenerator implements PowerGenerator {
    @Override
    public int generate() {
        return new Random().nextInt(10);
    }
}
