package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class Competition {
    private final Cars cars;
    private final int round;

    public Competition(String[] carNameArr, int round) {
        cars = new Cars(carNameArr);
        this.round = round;
    }

    public List<Cars> progressEntireRoundAndRecordAllSnapshot(Movable movable) {
        List<Cars> snapshots = new ArrayList<>(round);
        for (int i = 0; i < round; i++) {
            snapshots.add(i, progressEachRound(movable));
        }
        return snapshots;
    }

    public String getWinner(Cars snapshot) {
        return cars.getWinner(snapshot);
    }

    private Cars progressEachRound(Movable movable) {
        return cars.move(movable);
    }
}
