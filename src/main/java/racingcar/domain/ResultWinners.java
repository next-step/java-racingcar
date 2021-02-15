package racingcar.domain;

import java.util.List;
import java.util.Objects;

public class ResultWinners {
    private List<String> winners;

    public ResultWinners(List<String> winners) {
        this.winners = winners;
    }

    public List<String> getWinners() {
        return winners;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultWinners that = (ResultWinners) o;
        return Objects.equals(winners, that.winners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winners);
    }
}
