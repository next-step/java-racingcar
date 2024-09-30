package CarRacing;

public class CarRacing {

    public static final int BOUND = 10;
    public static final int MIN_MOVE_VALUE = 4;

    public boolean shouldMove(int randomValue) {
        return randomValue >= MIN_MOVE_VALUE;
    }
}
