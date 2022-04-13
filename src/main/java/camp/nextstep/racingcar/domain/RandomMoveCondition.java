package camp.nextstep.racingcar.domain;

public class RandomMoveCondition implements MoveCondition {

    public static final int CONDITIONAL_VALUE = 4;

    private final RandomGenerator randomGenerator;

    public RandomMoveCondition(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    @Override
    public boolean isSatisfied() {
        int randomNumber = randomGenerator.generate();
        if (randomNumber >= CONDITIONAL_VALUE) {
            return true;
        }
        return false;
    }

}
