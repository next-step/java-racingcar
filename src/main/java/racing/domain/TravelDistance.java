package racing.domain;

import java.util.Objects;

public class TravelDistance {

    private final int position;

    public TravelDistance() {
        this(0);
    }

    public TravelDistance(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("이동거리는 0 보다 작을 수 없습니다.");
        }
        this.position = position;
    }

    public TravelDistance move() {
        return new TravelDistance(position + 1);
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TravelDistance that = (TravelDistance) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
