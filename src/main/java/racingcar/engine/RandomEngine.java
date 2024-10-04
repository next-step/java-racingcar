package racingcar.engine;

import java.util.Random;

public class RandomEngine implements CarEngine {

    public static final int RANDOM_BOUND = 10;
    private static final Random RANDOM = new Random();
    private int energy;

    private RandomEngine(int energy) {
        this.energy = energy;
    }

    public static CarEngine createCarEngine() {
        return new RandomEngine(RANDOM.nextInt(RANDOM_BOUND));
    }

    @Override
    public boolean hasEnoughPower(int defaultMoveEnergy) {
        return energy >= defaultMoveEnergy;
    }
}
