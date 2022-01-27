package racingcar.domain;

public class FixedEngine implements Engine {

    private boolean strategy;

    protected FixedEngine(boolean strategy) {
        this.strategy = strategy;
    }

    @Override
    public boolean movable() {
        return strategy;
    }
}
