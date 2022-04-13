package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class Competition {
    private final Cars cars;
    private final int round;
    private Movable movable;

    public Competition(int unit, int round, Movable movable) {
        cars = new Cars(unit);
        this.round = round;
        this.movable = movable;
    }

    public Cars progressEntireRoundAndRecordLastSnapshot() {
        for (int i = 0; i < round; i++) {
            progressEachRound();
        }
        return cars;
    }

    public List<Cars> progressEntireRoundAndRecordAllSnapshot() {
        List<Cars> snapshots = new ArrayList<>(round);
        for (int i = 0; i < round; i++) {
            snapshots.add(i, progressEachRound().newInstance());
        }
        return snapshots;
    }

    private Cars progressEachRound() {
        for (Car car : cars.getCars()) {
            car.move(movable);
        }
        return cars;
    }
}
