package domain.type;

import java.util.Objects;

/**
 * 월드 상 존재할 수 있는 요소들의 위치를 표시하기 위한 타입 클래스
 * 불변 객체입니다.
 */
public class Position {
    private int position = 0;

    public Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("위치는 0 이상이어야 합니다.");
        }

        this.position = position;
    }

    /**
     * 좌표 원점 위치를 반환합니다.
     *
     * @return 좌표 원점
     */
    public static Position origin() {
        return new Position(0);
    }

    /**
     * 이 위치에 변위를 더해 새 위치를 계산합니다.
     *
     * @param move 변위
     *
     * @return 새 위치
     */
    public Position add(int move) {
        return new Position(this.position + move);
    }

    /**
     * 좌표 원점으로부터 이 위치까지의 길이를 계산합니다.
     *
     * @return 길이
     */
    public int length() {
        return this.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    public boolean isBiggerThan(Position p) {
        return this.position > p.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public String toString() {
        return "Position{" +
                "position=" + position +
                '}';
    }
}
