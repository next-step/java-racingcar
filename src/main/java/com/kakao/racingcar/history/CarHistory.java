package com.kakao.racingcar.history;

import java.util.Objects;

public class CarHistory implements Comparable<CarHistory> {

    private static final Integer NON_MOVE_POSITION = -1;

    private final int position;
    private final String userName;

    public CarHistory(int position, String userName) {
        this.position = position;
        this.userName = userName;
    }

    public static CarHistory createNonMoveHistory() {
        return new CarHistory(NON_MOVE_POSITION, "");
    }

    public int getPosition() {
        return position;
    }

    public String getUserName() {
        return userName;
    }

    public boolean isEqualPosition(CarHistory carHistory) {
        return this.position == carHistory.position;
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

    @Override
    public int compareTo(CarHistory carHistory) {
        return Integer.compare(this.position, carHistory.position);
    }
}
