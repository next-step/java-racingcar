package core;

import java.util.Random;

public class RandomPowerSupply implements PowerSupply {
    @Override
    public int supply() {
        Random random = new Random();
        return random.nextInt(Car.MAX_MOVE_VALUE);
    }
}
