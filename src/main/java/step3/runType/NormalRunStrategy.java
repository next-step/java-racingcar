package step3.runType;

public class NormalRunStrategy implements RunStrategy {

    @Override
    public int run() {
        if (canProgress()) {
            return NORMAL_PROGRESS_DISTANCE;
        }
        return NO_PROGRESS_DISTANCE;
    }
}
