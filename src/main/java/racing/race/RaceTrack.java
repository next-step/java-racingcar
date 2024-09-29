package racing.race;

import racing.RaceRule;
import racing.input.RaceInput;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RaceTrack {

    private final RaceInput raceInput;
    private final List<RaceCar> raceCars;

    public RaceTrack(RaceInput raceInput) {
        this.raceInput = raceInput;
        raceCars = prepareRace(raceInput.getNumOfCar());
    }

    private List<RaceCar> prepareRace(int numOfCar) {
        List<RaceCar> raceRecords = new ArrayList<>();

        for (int i = 0; i < numOfCar; i++) {
            raceRecords.add(new RaceCar());
        }
        return raceRecords;
    }

    public void race(RaceRule recordChecker) {
        for (int i = 0; i < raceInput.getNumOfAttempt(); i++) {
            raceCars.forEach(raceRecord -> raceRecord.race(recordChecker.isForward()));
        }
    }

    public List<RaceRecord> getRaceResult() {
        return raceCars.stream()
                .map(RaceCar::raceRecord)
                .collect(Collectors.toUnmodifiableList());
    }
}
