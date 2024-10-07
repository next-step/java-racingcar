package race.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Race {
    public static RaceResult start(RaceInput raceInput) {
        RacingCars cars = RacingCars.from(raceInput.carNames());

        Map<Integer, List<String>> roundCarStateMessageMap = new HashMap<>();
        for (int round = 0; round < raceInput.gameCount(); round++) {
            List<String> carStateMessages = cars.startRound();
            roundCarStateMessageMap.put(round, carStateMessages);
        }

        List<String> winners = cars.findWinners();

        return new RaceResult(winners, roundCarStateMessageMap);
    }
}
