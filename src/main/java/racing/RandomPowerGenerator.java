package racing;

import java.util.Random;

public class RandomPowerGenerator implements PowerGenerator {
    @Override
    public int generate() {
        return new Random(10).nextInt();
    }
}
