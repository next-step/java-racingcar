package racingcar.domain.engine;

public abstract class Engine {

    protected static final int MIN_INPUT = 0;
    protected static final int MAX_INPUT = 9;

    public abstract int operate(int input);
}
