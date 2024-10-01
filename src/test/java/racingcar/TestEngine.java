package racingcar;

import racingcar.engine.CarEngine;
import racingcar.engine.RandomEngine;

public class TestEngine implements CarEngine {

    private int energy;

    public TestEngine(int energy) {
        this.energy = energy;
    }

    public static CarEngine createCarEngine(int energy) {
        return new TestEngine(energy);
    }

    @Override
    public boolean hasEnoughPower() {
        return energy >= RandomEngine.DEFAULT_MOVE_ENERGY;
    }
}
