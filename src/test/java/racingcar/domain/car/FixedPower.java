package racingcar.domain.car;

public class FixedPower implements Power {
    private boolean swtich;

    public FixedPower() {
        this.swtich = false;
    }

    @Override
    public boolean isMovable() {
        swtich = !swtich;
        return swtich;
    }
}
