package step3.runType;

public class HighSpeedRunStrategy implements RunStrategy {

    public static int NO_PROGRESS_DISTANCE = 0;
    public static int HIGH_SPEED_PROGRESS_DISTANCE = 2;
    private static int ENGINE_POWER_LIMIT = 9;
    private static int HIGH_POWER_BOUNDARY = 4;

    @Override
    public int run() {
        int enginePower = (int) (Math.random() * ENGINE_POWER_LIMIT);
        if (enginePower >= HIGH_POWER_BOUNDARY) {
            return HIGH_SPEED_PROGRESS_DISTANCE;
        }
        return NO_PROGRESS_DISTANCE;
    }

}
