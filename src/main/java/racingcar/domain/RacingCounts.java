package racingcar.domain;

import java.util.Objects;

public class RacingCounts {

    private int racingCounts;

    public RacingCounts(int racingCounts) {
        this.racingCounts = racingCounts;
    }
    public int getRacingCounts() {
        return this.racingCounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;
        RacingCounts that = (RacingCounts) o;
        return racingCounts == that.racingCounts;
    }

    @Override
    public int hashCode() {
        return Objects.hash(racingCounts);
    }
}
