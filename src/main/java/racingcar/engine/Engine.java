package racingcar.engine;

public abstract class Engine {

    protected final int minInput = 0;
    protected final int maxInput = 9;

    public abstract int operate(int input);
}
