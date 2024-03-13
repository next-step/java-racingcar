package racing;

import java.util.List;
import java.util.Objects;

public class Winners {
    private static final String WINNER_DELIMITER = ",";

    private final List<Car> winners;

    public Winners(List<Car> winners) {
        this.winners = winners;
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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car winner : winners) {
            StringUtil.addDelimiterToStringBuilder(stringBuilder, WINNER_DELIMITER);
            stringBuilder.append(winner.getName());
        }

        return stringBuilder.toString();
    }
}
