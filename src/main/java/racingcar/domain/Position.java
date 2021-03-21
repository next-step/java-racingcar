/*
 * 자동차의 위치를 원시값으로 포장한 불변 객체
 *
 * @author hj-woo
 * @version 1.0
 * */

package racingcar.domain;

import racingcar.utils.ErrorMessage;

import java.util.Objects;

public class Position implements Comparable<Position>{

    private int position;

    public Position() {
        this.position = 0;
    }

    public Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException(ErrorMessage.ILLEGAL_POSITION);
        }

        this.position = position;
    }

    public Position move() {
        return new Position(position + 1);
    }

    public boolean isSame(int checkPosition) {
        return position == checkPosition;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public int compareTo(Position o) {
        return position > o.position ? +1 : position < o.position? -1 : 0;
    }
}
