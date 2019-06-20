package racingcar.logic;

public class DefaultCarEngine implements CarEngine {

    private static final Integer FORWARD_THRESHOLD = 4;
    private final RandomValueProvider randomValueProvider;

    public DefaultCarEngine(RandomValueProvider randomValueProvider) {
        this.randomValueProvider = randomValueProvider;
    }

    @Override
    public boolean isMove() {
        return randomValueProvider.get() > FORWARD_THRESHOLD;
    }
}
