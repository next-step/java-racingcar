package racing.car.random;

public class GenerateRandom implements Random {
    private static final int SPEED_MAX = 10;
    java.util.Random ran = new java.util.Random();

    @Override
    public int random() {
        return ran.nextInt(SPEED_MAX);
    }


}
