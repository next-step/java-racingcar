package racingcar.domain;

public class FixedEngine implements Engine {

    private final int fixedPower;

    public FixedEngine(int fixedPower) {
        this.fixedPower = fixedPower;
    }

    @Override
    public int getPower() {
        return fixedPower;
    }
}
