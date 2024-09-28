package race;

import java.util.Random;

public class Car {

    private static final int randomRange = 10;

    public int getConditionNumber() {
        return new Random().nextInt(randomRange);
    }
}
