import java.util.Random;

public class CarRacingRules {
    private static final int MAX_RANGE = 10;
    private static final int GO_FORWARD_CRITERIA = 4;


    public static int randomRange()  {
        return new Random().nextInt(MAX_RANGE);
    }

    public static boolean determineToGoForwardOrStop(int value) {
        return value >= GO_FORWARD_CRITERIA;
    }
}
