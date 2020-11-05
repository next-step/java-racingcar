package humbledude.carracing.domain;

public class ConstantFuelGenerator implements FuelGenerator{
    private int seed;

    public ConstantFuelGenerator(int seed) {
        this.seed = seed;
    }

    @Override
    public int generate() {
        return seed;
    }
}
