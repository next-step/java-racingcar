package racing.car.random;

public class GenerateRandom implements Random {
    private static final int SPEED_MAX = 10;
    private static final java.util.Random RANDOM_GENERATOR = new java.util.Random();

    @Override
    public int random() {
        return RANDOM_GENERATOR.nextInt(SPEED_MAX);
    }


}
