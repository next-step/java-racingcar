package racing;

public class Under10Random implements Random {

    public static final int RANDOM_MAX = 10;

    @Override
    public int getRandomNumber() {
        java.util.Random random = new java.util.Random();
        return random.nextInt(RANDOM_MAX);
    }
}
