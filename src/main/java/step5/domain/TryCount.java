package step5.domain;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class TryCount {
    private final int value;

    public TryCount(int value) {
        this.value = value;
    }

    public boolean zeroOrLessThanZero() {
        return value <= 0;
    }

    public void forEach(IntConsumer action) {
        IntStream.range(0, value).forEach(action);
    }
}
