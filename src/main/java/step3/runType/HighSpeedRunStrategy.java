package step3.runType;

public class HighSpeedRunStrategy implements RunStrategy {

    @Override
    public int run() {
        if (canProgress()) {
            return NORMAL_PROGRESS_DISTANCE;
        }
        return HIGH_SPEED_PROGRESS_DISTANCE;
    }
}
