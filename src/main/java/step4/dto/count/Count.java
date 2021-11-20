package step4.dto.count;

import step4.common.MyException;
import step4.common.MyNumber;

import java.util.Objects;

public class Count {
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

    public boolean lessThanOther(Count other) {
        return this.count <= other.count;
    }

    public boolean moreThanOther(Count other) {
        return this.count >= other.count;
    }

    private static void lessThanOneOrElseThrow(int input) {
        if(input < MyNumber.ZERO.getValue()) {
            throw new IllegalArgumentException(MyException.VALUE_GREATER_THAN_ZERO.getMessage());
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
