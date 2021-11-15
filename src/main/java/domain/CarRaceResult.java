package domain;

import java.util.ArrayList;
import java.util.List;

public class CarRaceResult {
    private final CarRaceGroup carRaceGroup;

    public CarRaceResult(CarRaceGroup carRaceGroup) {
        this.carRaceGroup = carRaceGroup;
    }

    public List<CarRaceGroup> raceResult(CarRaceCount carRaceCount) {
        List<CarRaceGroup> result = new ArrayList<>();
        int raceCount = carRaceCount.count();

        for (int i = 0; i < raceCount; i++) {
            result.add(carRaceGroup.racing());
        }

        return result;
    }

    public String winnerName() {
        return carRaceGroup.findWinner();
    }

    public int positionMax() {
        return carRaceGroup.positionMax();
    }
}
