package game.domain.rule;

import java.util.Objects;

public class Bound {

    private int bound;

    public Bound(int bound) {
        this.bound = bound;
    }

    public Bound(Bound bound) {
        this(bound.getBound());
    }

    public int getBound() {
        return bound;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bound bound1 = (Bound) o;
        return bound == bound1.bound;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bound);
    }
}
