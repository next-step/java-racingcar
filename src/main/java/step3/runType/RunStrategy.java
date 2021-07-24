package step3.runType;

public interface RunStrategy {

    int NO_PROGRESS_DISTANCE = 0;
    int NORMAL_PROGRESS_DISTANCE = 1;
    int HIGH_SPEED_PROGRESS_DISTANCE = 2;

    int ENGINE_POWER_LIMIT = 9;
    int HIGH_POWER_BOUNDARY = 4;

    int run();

    default boolean canProgress() {
        int enginePower = (int) (Math.random() * ENGINE_POWER_LIMIT);
        if (enginePower >= HIGH_POWER_BOUNDARY) {
            return true;
        }
        return false;
    }
}
