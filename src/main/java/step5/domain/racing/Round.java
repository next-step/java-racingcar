package step5.domain.racing;

import java.util.Objects;

/**
 * Created By mand2 on 2020-11-14.
 */
public class Round {

    private final int rounds;

    private Round(int rounds) {
        this.rounds = rounds;
    }

    public static Round of(int rounds) {
        return new Round(rounds);
    }

    public int round() {
        return this.rounds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round round = (Round) o;
        return rounds == round.rounds;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rounds);
    }
}
