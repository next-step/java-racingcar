/*
 * 클래스 이름
 * 위치
 * 버전 정보
 * 1.0
 * 날짜
 * 2020.11.01
 * 저작권 주의
 */

package model;

import java.util.Objects;

public class Position {
    private int position;

    public Position () {
        this(0);
    }

    public Position (int position) {
        if (position < 0) {
            throw new IllegalArgumentException("position은 0보다 커야 합니다.");
        }
        this.position = position;
    }

    public Position move () {
        return new Position(position + 1);
    }

    public void print () {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode () {
        return Objects.hash(position);
    }
}
