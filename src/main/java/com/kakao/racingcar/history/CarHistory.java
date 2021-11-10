package com.kakao.racingcar.history;


import java.util.Objects;

public class CarHistory {
    private final int position;
    private final String userName;

    public CarHistory(int position, String userName) {
        this.position = position;
        this.userName = userName;
    }

    public int getPosition() {
        return position;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarHistory that = (CarHistory) o;
        return position == that.position && Objects.equals(userName, that.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, userName);
    }
}
