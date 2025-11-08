package caculator;

import java.util.Objects;

public record PositiveOrZero(int value) {

    public PositiveOrZero(int value) {
        this.value = value;
        validateInvariant();
    }

    public PositiveOrZero(String text) {
        this(Integer.parseInt(text));
    }

    private void validateInvariant() {
        if (isNegative()) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + this.value);
        }
    }

    private boolean isNegative() {
        return this.value < 0;
    }

    public PositiveOrZero add(PositiveOrZero other) {
        Objects.requireNonNull(other);
        return new PositiveOrZero(this.value + other.value);
    }
}
