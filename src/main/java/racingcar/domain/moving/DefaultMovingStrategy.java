package racingcar.domain.moving;

public class DefaultMovingStrategy implements MovingStrategy {

    private static final Integer FORWARD_THRESHOLD = 4;
    private final RandomValueProvider randomValueProvider;

    public DefaultMovingStrategy(RandomValueProvider randomValueProvider) {
        this.randomValueProvider = randomValueProvider;
    }

    @Override
    public boolean movable() {
        return randomValueProvider.get() > FORWARD_THRESHOLD;
    }
}
