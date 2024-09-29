package racinggame;

import java.util.Objects;

public class RacingCar {
    public static final int MOVE_THRESHOLD = 4;

    private int id;
    private int position;

    public RacingCar(final int id) {
        this.id = id;
        this.position = 0;
    }

    public boolean move(final int moveCondition) {
        if (moveCondition > MOVE_THRESHOLD) {
            this.position++;
            return true;
        }

        return false;
    }

    // 우승자 처리 시 사용예정
    public int currentPosition() {
        return this.position;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        final RacingCar racingCar = (RacingCar) obj;
        return Objects.equals(id, racingCar.id);
    }
}
