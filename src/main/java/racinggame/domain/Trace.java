package racinggame.domain;

import java.util.Objects;

public class Trace {
    private int value;

    public Trace() {
        this(0);
    }
    
    public Trace(int trace) {
        if (trace < 0) {
            throw new IllegalArgumentException("trace는 음수 값을 가질 수 없습니다.");
        }
        this.value = trace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)  return true;
        if (o == null || getClass() != o.getClass())    return false;
        Trace trace1 = (Trace) o;
        return value == trace1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public int getValue() {
        return this.value;
    }

    public Trace move() {
        value = value + 1;
        return this;
    }

    public boolean lessThan(int value) {
        return this.value < value;
    }
}
