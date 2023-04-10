package carracing.domain;

import java.util.List;
import java.util.Objects;
import java.util.function.IntUnaryOperator;

public class Round implements Comparable<Round> {
    private static final int FIRST_ROUND_VALUE = 1;
    private static final IntUnaryOperator validate = value -> {
        if (value < FIRST_ROUND_VALUE) {
            return value;
        }
        throw new RuntimeException("라운드는 1부터 시작하므로 항상 1 이상입니다");
    };
    private int id;
    private List<Score> scoreList;
    private List<String> record;

    public Round(int id) {
        this.id = validate.applyAsInt(id);
    }

    public Round previousRound() {
        if (isFirstRound()) {
            return this;
        }
        return new Round(id - 1);
    }

    public boolean isFirstRound() {
        return this.id == FIRST_ROUND_VALUE;
    }




    @Override
    public int compareTo(Round other) {
        return Integer.compare(this.getId(), other.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round round = (Round) o;
        return id == round.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
