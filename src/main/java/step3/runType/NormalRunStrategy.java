package step3.runType;

public class NormalRunStrategy implements RunStrategy {

    public static int NO_PROGRESS_DISTANCE = 0;
    public static int NORMAL_PROGRESS_DISTANCE = 1;
    private static int ENGINE_POWER_LIMIT = 9;
    private static int HIGH_POWER_BOUNDARY = 4;

    @Override
    public int run() {
        int enginePower = (int) (Math.random() * ENGINE_POWER_LIMIT);
        if (enginePower >= HIGH_POWER_BOUNDARY) {
            return NORMAL_PROGRESS_DISTANCE;
        }
        return NO_PROGRESS_DISTANCE;
    }
}
