package car_racing2.domain.model;

import java.util.ArrayList;
import java.util.List;

public class RaceResult {
    private static final String CAR_RESULT_DELIMITER = "\n";
    private static final String WINNERS_DELIMITER = ", ";

    private final List<String> resultOfRounds = new ArrayList<>();
    private final StringBuilder winners = new StringBuilder();

    public void recordResultOfRound(List<String> carsNameWithPosition) {
        this.resultOfRounds.add(String.join("", carsNameWithPosition));
    }

    public void recordRaceWinners(List<String> winners) {
        this.winners.append(String.join(WINNERS_DELIMITER, winners));
    }

    public String getResultOfRounds() {
        return String.join(CAR_RESULT_DELIMITER, resultOfRounds);
    }

    public String getWinners() {
        return winners.toString();
    }
}
