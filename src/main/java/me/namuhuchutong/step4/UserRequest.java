package me.namuhuchutong.step4;

public class UserRequest {

    private final String names;

    private final int times;

    public UserRequest(String names, int times) {
        validateEmptyString(names);
        this.names = names;
        this.times = times;
    }

    private void validateEmptyString(String names) {
        if (names.isBlank()) {
            throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
        }
    }

    public String getNames() {
        return names;
    }

    public int getTimes() {
        return times;
    }
}
