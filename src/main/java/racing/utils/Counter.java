package racing.utils;

import java.util.Objects;

public class Counter {
    private int count;

    private Counter() {
        count = 0;
    }

    public Counter(int count) {
        this.count = count;
    }

    public Counter(Counter counter) {
        Objects.requireNonNull(counter);
        count = counter.getCount();
    }

    public int getCount() {
        return count;
    }

    public void add(int runStep) {
        count = count + runStep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Counter counter = (Counter) o;
        return getCount() == counter.getCount();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCount());
    }
}
