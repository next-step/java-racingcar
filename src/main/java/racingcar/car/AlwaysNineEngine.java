package racingcar.car;

public class AlwaysNineEngine implements Engine {

    private static final int NINE = 9;

    @Override
    public int generateNumber() {
        return NINE;
    }

    @Override
    public int getPreviousNumber() {
        return NINE;
    }

    @Override
    public boolean isMoved() {
        return true;
    }
}
