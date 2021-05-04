package racing.service;

import java.util.Objects;

public class Round {
    private final int round;

    private Round(int round) {
        this.round = round;
    }

    public static Round of(int round) {
        validate(round);
        return new Round(round);
    }

    private static void validate(int round) {
        if (round < 1) {
            throw new IllegalArgumentException("라운드 숫자는 1보다 커야합니다.");
        }
    }

    public int getRound() {
        return round;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round round1 = (Round) o;
        return round == round1.round;
    }

    @Override
    public int hashCode() {
        return Objects.hash(round);
    }
}
