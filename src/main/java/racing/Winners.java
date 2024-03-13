package racing;

import java.util.List;

public class Winners {
    private static final String WINNER_DELIMITER = ",";

    private final List<Car> winners;

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
