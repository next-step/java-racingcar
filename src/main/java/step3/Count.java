package step3;

import java.util.Objects;

public class Count {
    private int ZERO = 0;
    private int count;

    public Count() {
        this.count = ZERO;
    }

    public Count(Integer input) {
        this.count = input;
    }

    public void plusCount() {
        this.count++;
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Count count1 = (Count) o;
        return count == count1.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
