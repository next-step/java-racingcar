package racingcar.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Winners {

    private static final String WINNER_DELIMITER = ", ";

    private final List<Name> winners;

    public Winners(List<Name> winners) {
        this.winners = winners;
    }

    public static Winners of(List<Name> winners) {
        return new Winners(winners);
    }

    public String winnersToString() {
        return winners.stream().map(Name::getName).collect(Collectors.joining(WINNER_DELIMITER));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Winners winners1 = (Winners) o;
        return Objects.equals(winners, winners1.winners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winners);
    }
}
