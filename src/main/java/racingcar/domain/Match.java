package racingcar.domain;

import java.util.Objects;

public class Match {
    private int matchCount;

    public Match(int matchCount) {
        this.matchCount = matchCount;
    }

    public void match() {
        this.matchCount--;
    }

    public boolean isMatching() {
        return this.matchCount > 0;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Match match = (Match) object;
        return matchCount == match.matchCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchCount);
    }
}
