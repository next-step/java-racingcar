package step4.domain;

import java.util.Objects;

public class Position {

    private int position;

    public Position() {
        this(0);
    }

    public Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("position은 음수 값을 가질 수 없습니다.");
        }
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void plus() {
        position++;
    }

    // 외부에 의해 값이 변할수 없게하는 임모터블 오브젝트 즉 불변객체를 구현할수 있다 (valueObject)
    // 객체이 position값을 변경할수 없음.
    // 단점은 인스턴스가 매번 만들어지며 가비지 컬렉션이 많이 발생하여 성능저하.
    public Position move() {
        return new Position(position + 1);
    }

    // 가변객체. 인스터스 생성 방지.
    public Position move2() {
        position++;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    public boolean lessThan(Position maxPositon) {
        return maxPositon.position > position;
    }

    public boolean isZero() {
        return position == 0;
    }
}
