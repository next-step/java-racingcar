package racingcar.movable;

import racingcar.number_generator.NumberGenerator;
import racingcar.number_generator.RandomNumberGenerator;

public class RandomMovable implements Movable{

    public static final int THRESHOLD_NUMBER = 4;

    private final NumberGenerator numberGenerator;

    public RandomMovable() {
        this.numberGenerator = new RandomNumberGenerator();
    }

    RandomMovable(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public boolean canMove() {
        return THRESHOLD_NUMBER <= numberGenerator.generate();
    }
}
