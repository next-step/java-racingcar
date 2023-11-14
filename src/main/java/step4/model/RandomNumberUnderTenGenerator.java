package step4.model;

import java.util.Random;

public class RandomNumberUnderTenGenerator implements NumberGenerator {

    @Override
    public int generate() {
        return new Random().nextInt(10);
    }
}
