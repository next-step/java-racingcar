package step3.runType;

public class TestRunStrategy implements RunStrategy {

    public static int NORMAL_PROGRESS_DISTANCE = 1;

    @Override
    public int run() {
        return NORMAL_PROGRESS_DISTANCE;
    }
}
