package carracing.domain;

public class TryCount {
    private final int value;

    public TryCount(int value) {
        this.value = value;
    }

    public boolean countOver() {
        return value == 0;
    }

    public TryCount consume() {
        return new TryCount(value - 1);
    }
}
