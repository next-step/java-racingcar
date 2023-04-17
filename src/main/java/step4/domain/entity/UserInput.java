package step4.domain.entity;

import step4.exception.NegativeNumberException;

import java.util.Objects;

public class UserInput {

    private final String name;

    private final int retry;

    public UserInput(String name, int retry) {
        validate(name);
        validate(retry);

        this.name = name;
        this.retry = retry;
    }

    private void validate(String name) {
        Objects.requireNonNull(name, "자동차 이름은 null 이 될 수 없습니다.");
    }

    private void validate(int retry) {
        if (retry < 0) {
            throw new NegativeNumberException("시도할 횟수는 0보다 커야 합니다. retry: " + retry);
        }
    }

    public String getName() {
        return name;
    }

    public int getRetry() {
        return retry;
    }
}
