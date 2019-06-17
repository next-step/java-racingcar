package racing.dto;

import java.util.ArrayList;
import java.util.List;

public class RacingResult {

    private List<RacingPosition> racingPositions = new ArrayList<>();

    public RacingPosition getRacingPosition(int raceCount) {

        return racingPositions.get(raceCount);
    }

    public void addCurrentRacingPosition(EntireCars entireCars) {

        racingPositions.add(RacingPosition.of(entireCars));
    }

    public int length() {

        return racingPositions.size();
    }
}
