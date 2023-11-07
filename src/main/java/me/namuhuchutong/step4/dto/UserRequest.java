package me.namuhuchutong.step4.dto;

public class UserRequest {

    private final String names;

    private final int times;

    public UserRequest(String names, int times) {
        validateEmptyString(names);
        validateRacingTimes(times);
        this.names = names;
        this.times = times;
    }

    private void validateEmptyString(String names) {
        if (names.isBlank()) {
            throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
        }
    }

    private void validateRacingTimes(int times) {
        if (times <= 0) {
            throw new IllegalArgumentException("경주 수는 음수이거나 0일 수 없습니다. - " + times);
        }
    }

    public String getNames() {
        return names;
    }

    public int getTimes() {
        return times;
    }
}
