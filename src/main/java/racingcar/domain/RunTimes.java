package racingcar.domain;

public class RunTimes {
    private static int TIMES_END = 0;
    private int times;

    public RunTimes(int times) {
        this.times = times;
    }

    public boolean isDuringGame() {
        return times > TIMES_END;
    }

    public void decrease() {
        this.times--;
    }
}
