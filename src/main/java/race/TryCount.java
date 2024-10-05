package race;

import java.util.Objects;

public class TryCount {
    private final int value;

    public TryCount(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof TryCount))
            return false;
        TryCount tryCount = (TryCount)o;
        return value == tryCount.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
