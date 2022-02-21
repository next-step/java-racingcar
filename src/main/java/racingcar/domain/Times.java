package racingcar.domain;

public class Times {

    private final int minTimes = 1;
    private int times;

    public Times(int times) {
        validateTimes(times);
        this.times = times;
    }

    private void validateTimes(int times) {
        if (times < minTimes) {
            throw new IllegalArgumentException("[ERROR] - 0보다 큰 정수를 입력해주세요.");
        }
    }

    public int getTimes() {
        return times;
    }

    public boolean isOngoing() {
        return times > 0;
    }

    public void decrease() {
        times--;
    }
}
