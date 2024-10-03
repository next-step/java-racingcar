package racing.domain;

import racing.RaceRule;
import racing.dto.RaceInfo;
import racing.dto.RaceLineUp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RaceTrack {

    private final RaceInfo raceInput;
    private final List<RaceCar> raceCars;

    public RaceTrack(RaceInfo raceInput) {
        this.raceInput = raceInput;
        raceCars = prepareRace(raceInput.raceLineUp());
    }

    private List<RaceCar> prepareRace(RaceLineUp raceLineup) {
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

    public RaceResult getRaceResult() {
        return new RaceResult(raceCars.stream()
                .map(RaceCar::raceRecord)
                .collect(Collectors.toList())
        );
    }
}
