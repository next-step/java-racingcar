package racingcar;

import java.util.Objects;

public class GameCount {

    private static final int MIN_GAME_COUNT = 1;
    private static final String ERROR_GAME_COUNT = "게임 횟수는 최소 " + MIN_GAME_COUNT + "회 이상이어야 합니다.";

    private final int value;

    public GameCount(int value) {
        validate(value);
        this.value = value;
    }

    public int asInt() {
        return value;
    }

    private void validate(int value) {
        if (value < MIN_GAME_COUNT) {
            throw new IllegalArgumentException(ERROR_GAME_COUNT);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameCount gameCount = (GameCount) o;
        return value == gameCount.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
