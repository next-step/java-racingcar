package car_racing.domain.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RaceResults {
    private final List<RaceResultOfRound> raceResults = new ArrayList<>();

    public void addRaceResult(RaceResultOfRound raceResult) {
        raceResults.add(raceResult);
    }

    public String getRaceResultOfNthRound(int round) {
        RaceResultOfRound raceResult = raceResults.get(round);
        return raceResult.toString();
    }

    public List<String> getWinnersName() {
        if (raceResults.isEmpty()) return Collections.emptyList();

        RaceResultOfRound resultOfLastRound = raceResults.get(raceResults.size() - 1);
        int maxDistance = resultOfLastRound.getMaxPosition();

        return resultOfLastRound.getWinners(maxDistance);
    }

}
