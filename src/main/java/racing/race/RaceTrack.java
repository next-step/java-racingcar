package racing.race;

import racing.RaceRule;
import racing.input.RaceLineup;
import racing.input.RaceInput;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RaceTrack {

    private final RaceInput raceInput;
    private final List<RaceCar> raceCars;

    public RaceTrack(RaceInput raceInput) {
        this.raceInput = raceInput;
        raceCars = prepareRace(raceInput.raceLineup());
    }

    private List<RaceCar> prepareRace(RaceLineup raceLineup) {
        List<RaceCar> raceRecords = new ArrayList<>();

        for (String carName : raceLineup.names()) {
            raceRecords.add(new RaceCar(carName));
        }
        return raceRecords;
    }

    public void race(RaceRule recordChecker) {
        for (int i = 0; i < raceInput.attemptNumber().getValue(); i++) {
            raceCars.forEach(raceRecord -> raceRecord.race(recordChecker.isForward()));
        }
    }

    public List<RaceRecord> getRaceResult() {
        return raceCars.stream()
                .map(RaceCar::raceRecord)
                .collect(Collectors.toUnmodifiableList());
    }
}
