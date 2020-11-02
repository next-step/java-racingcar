package humbledude.carracing;

public class ConstantFuelGenerator implements FuelGenerator{
    int seed;
    public ConstantFuelGenerator(int seed) {
        this.seed = seed;
    }

    @Override
    public int generate() {
        return seed;
    }
}
