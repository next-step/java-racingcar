package step3;

import java.util.Objects;

public class Count {
    private final static int MIN = 1;
    private int count;

    public Count(int count) {
        lessThanOneOrElseThrow(count);

        this.count = count;
    }

    public void plusCount() {
        this.count++;
    }

    public int getCount() {
        return count;
    }

    public boolean lessOrEqualsThanOther(Count other) {
        return this.count <= other.count;
    }

    private static void lessThanOneOrElseThrow(int input) {
        if(input < MIN) {
            throw new IllegalArgumentException(MyException.VALUE_GREATER_THAN_ONE.getMessage());
        }
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
