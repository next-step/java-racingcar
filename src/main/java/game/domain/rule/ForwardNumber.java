package game.domain.rule;

import java.util.Objects;

public class ForwardNumber {

    private int forwardNumber;

    public ForwardNumber(int forwardNumber) {
        if (forwardNumber < 0) {
            throw new IllegalArgumentException("ForwardNumber는 음수일 수 없습니다.");
        }
        this.forwardNumber = forwardNumber;
    }

    public ForwardNumber(ForwardNumber forwardNumber) {
        this(forwardNumber.getForwardNumber());
    }

    private int getForwardNumber() {
        return forwardNumber;
    }

    public boolean isForward(int number) {
        return number >= forwardNumber;
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
