package com.kakao.racingcar.domain.car;

import java.util.Objects;

public class UserName {
    private final String value;

    public UserName(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String userName) {
        if (userName.length() > 5) {
            throw new IllegalArgumentException("유저 이름은 5자를 넘을 수 없습니다.");
        }
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserName userName = (UserName) o;
        return Objects.equals(value, userName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
