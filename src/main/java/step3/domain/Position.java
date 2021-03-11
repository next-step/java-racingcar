package step3.domain;

import java.util.Objects;

/**
 * primitive 타입 데이터의 관리
 * <pre>
 *      // 생성자를 통한 값 주입이 아닌 이상 값이 변하지 않는 immutable object
 *      public Position move() {
 *         return new Position(position + 1);
 *     }
 * </pre>
 * <pre>
 *     // 내부에서 관리하는 값이 변하는 mutable object (위 문제의 성능 이슈를 줆임)
 *     public Position move() {
 *         position = position + 1;
 *         return this;
 *     }
 * </pre>
 *
 */
public class Position {

    private final int position;

    public Position() {
        this(0);
    }

    public Position(int position) {
        if(position < 0) {
            throw new IllegalArgumentException("position은 음수 값을 가질 수 없다.");
        }
        this.position = position;
    }

    public Position move() {
        return new Position(position + 1);
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPosition());
    }
}
