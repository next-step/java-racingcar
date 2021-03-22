package step5.domain;

import java.util.Objects;

public class Position {
    private int position;

    public Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("자동차 이름은 값이 존재해야 합니다.");
        }
        this.position = position;
    }

    // 여기도 getter를 쓰게 되는... 안쓰는 방법이란... 조언 부탁드립니다 ㅠㅠ
    public int getPosition() {
        return position;
    }

    public Position move() {
        position++;
        return this;
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
}
