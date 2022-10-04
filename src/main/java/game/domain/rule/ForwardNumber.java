package game.domain.rule;

import java.util.Objects;

public class ForwardNumber {

    private int forwardNumber;

    public ForwardNumber(int forwardNumber) {
        this.forwardNumber = forwardNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ForwardNumber that = (ForwardNumber) o;
        return forwardNumber == that.forwardNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(forwardNumber);
    }
}
