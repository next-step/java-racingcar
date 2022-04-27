package teacher.step4.domain;

import java.util.Objects;

public class Position {
    private final int position;

    public Position() {
        this(0);
    }

    public Position(String position) {
        this(Integer.parseInt(position));
    }

    // [생성자]
    // 이름과 파라미터수도 같은 생성자들이 있을 땐 인스턴스 변수를 초기화하는 것이 마지막 위치에 있는 것이 관례
    public Position(int position) {
        // [유효성 체크]
        // Position 으로 랩핑되었기에 유효성 체크가 수월해졌다.
        if (position < 0) {
            throw new IllegalArgumentException("음수가 될 수 없습니다.");
        }
        this.position = position;
    }

    public int getPosition() {
        return this.position;
    }

    public boolean isMaxPosition(int maxPosition) {
        return this.position == maxPosition;
    }

    public int maxPosition(int maxPosition) {
        if (maxPosition < this.position) {
            return this.position;
        }
        return maxPosition;
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
