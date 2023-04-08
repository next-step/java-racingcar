package core;

public class Random {

    public static final java.util.Random RANDOM = new java.util.Random();

    public static int generateRandom(int token) {
        return RANDOM.nextInt(token);
    }

}
