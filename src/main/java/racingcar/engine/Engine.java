package racingcar.engine;

public abstract class Engine {

    protected final int MIN_INPUT = 0;
    protected final int MAX_INPUT = 9;

    public abstract int operate(int input);
}
