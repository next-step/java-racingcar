package racingcar.domain;

public class Times {

    int times;

    public Times(String timesString) {
        int times = validateIsPositive(Integer.parseInt(timesString));
        this.times = times;
    }

    private int validateIsPositive(int times) {
        if (times <= 0) {
            throw new IllegalArgumentException("[ERROR] - 0보다 큰 정수를 입력해주세요.");
        }
        return times;
    }

    public int getTimes() {
        return times;
    }
}
