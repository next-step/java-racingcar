package racingcar.domain;

public class RunTimes {
    private static final int TIMES_END = 0;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RunTimes runTimes = (RunTimes) o;
        return times == runTimes.times;
    }
}
