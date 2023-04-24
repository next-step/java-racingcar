package step4.service;

public class RacingCarForward implements ForwardStrategy {

    private static final int RANDOM_BOUND = 10;
    private static final int CAR_FORWARD_MINIMUM_NUMBER = 4;

    private final NumberGenerator numberGenerator;

    public RacingCarForward(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public boolean isMovable() {
        return numberGenerator.random(RANDOM_BOUND) >= CAR_FORWARD_MINIMUM_NUMBER;
    }
}
