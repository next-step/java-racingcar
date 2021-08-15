package racing_refactoring.strategy;

public class CarStrategyImpl implements CarStrategy{

    private final static int INPUT_MAX_LENGTH = 5;
    private final static int INPUT_MIN_LENGTH = 1;

    @Override
    public boolean underMinLength(String name) {
        int nameLen = name.length();
        return nameLen < INPUT_MIN_LENGTH;
    }

    @Override
    public boolean underMinLength(int trial) {
        return trial < INPUT_MIN_LENGTH;
    }

    @Override
    public boolean overMaxLength(String name) {
        int nameLen = name.length();
        return nameLen > INPUT_MAX_LENGTH;
    }

    @Override
    public boolean underMinLength(String[] carNames) {
        return carNames.length < INPUT_MIN_LENGTH;
    }
}
