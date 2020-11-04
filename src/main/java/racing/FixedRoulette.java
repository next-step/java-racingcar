package racing;

public class FixedRoulette implements Roulette {

    private final int fixedValue;

    public FixedRoulette(int fixedValue) {
        this.fixedValue = fixedValue;
    }

    @Override
    public int spin() {
        return fixedValue;
    }
}
