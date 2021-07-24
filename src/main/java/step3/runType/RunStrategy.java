package step3.runType;

public interface RunStrategy {
    int NORMAL_PROGRESS_DISTANCE = 1;
    int HIGH_SPEED_PROGRESS_DISTANCE = 2;

    int run();
}
