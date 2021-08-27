package carracing.domain;

import java.util.ArrayList;
import java.util.List;

public class RaceResult {

    private List<Cars> raceResult;

    private List<Car> winners;

    public RaceResult(int raceCount) {
        this.raceResult = new ArrayList<>(raceCount);
        this.winners = new ArrayList<>();
    }

    public List<Cars> raceResult() {
        return raceResult;
    }

    public List<Car> winners() {
        return winners;
    }

    public void saveResult(Cars cars) {
        raceResult.add(cars);
    }

    public void saveWinners(List<Car> winners) {
        this.winners = winners;
    }

}
