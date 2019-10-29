package step2.car.domain.engine;

public class FixedEngine implements Engine {

    private int fixedPower;

    public FixedEngine(int fixedPower) {
        this.fixedPower = fixedPower;
    }

    @Override
    public int getPower() {
        return this.fixedPower;
    }
}
