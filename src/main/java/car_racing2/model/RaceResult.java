package car_racing2.model;

import java.util.ArrayList;
import java.util.List;

public class RaceResult {
    private static final String CAR_RESULT_DELIMITER = "\n";
    private static final String WINNERS_DELIMITER = ", ";

    private List<String> resultOfRounds = new ArrayList<>();
    private String winners = "";

    public void recordResultOfRound(List<String> carsNameWithPosition) {
        this.resultOfRounds.add(String.join("", carsNameWithPosition));
    }

    public void recordRaceWinners(List<String> winners) {
        this.winners = String.join(WINNERS_DELIMITER, winners);
    }

    public String getResultOfRounds() {
        String result = String.join(CAR_RESULT_DELIMITER, resultOfRounds);
        return result;
    }

    public String getWinners() {
        return winners;
    }
}
