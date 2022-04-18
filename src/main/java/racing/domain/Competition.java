package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class Competition {
    private final Cars cars;
    private final int round;

    public Competition(String[] carNames, int round) {
        cars = new Cars(carNames);
        this.round = round;
    }

    Competition(Cars cars) {
        this.cars = cars;
        round = 0;
    }

    public List<Cars> progressEntireRoundAndRecordAllSnapshot(Movable movable) {
        List<Cars> snapshots = new ArrayList<>(round);
        for (int i = 0; i < round; i++) {
            snapshots.add(i, progressEachRound(movable));
        }
        return snapshots;
    }

    private Cars progressEachRound(Movable movable) {
        return cars.move(movable);
    }

    public List<Car> getCarsWithMaxDistance(Cars snapshot) {
        return cars.getCarsWithMaxDistance(snapshot);
    }
}
