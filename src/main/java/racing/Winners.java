package racing;

import java.util.List;

public class Winners {
    private final List<Car> winners;

    private static final String WINNER_DELIMITER = ",";

    public Winners(List<Car> winners) {
        this.winners = winners;
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
