package race;

import java.util.List;

public class RaceResult {
    private final List<MoveResults> raceResult;

    public RaceResult(List<MoveResults> raceResult) {
        this.raceResult = raceResult;
    }

    public List<MoveResults> getRaceResult() {
        return List.copyOf(raceResult);
    }

    public int getLaps() {
        return raceResult.size();
    }

    public int getNumOfCars() {
        return raceResult.get(0)
                .getSize();
    }

    public MoveResult getMoveResultOfCarAtLap(int carNo, int lap) {
        return raceResult.get(lap)
                .getMoveResults()
                .get(carNo);
    }
}
