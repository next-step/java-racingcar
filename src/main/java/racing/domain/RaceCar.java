package racing.domain;

import racing.constant.RacePosition;

import java.util.ArrayList;
import java.util.List;

public class RaceCar {

    private final List<RacePosition> results = new ArrayList<>();

    private final String name;

    public RaceCar(String name) {
        this.name = name;
    }

    public void race(boolean isForward) {
        results.add(isForward ? RacePosition.FORWARD : RacePosition.STOP);
    }

    public RaceRecord raceRecord() {
        return new RaceRecord(name, List.of(accumulatedPoints()));
    }

    private Integer[] accumulatedPoints() {
        Integer[] accumulatedPoints = new Integer[results.size()];
        int accumulatedPoint = 0;

        for (int i = 0; i < results.size(); i++) {
            accumulatedPoint += results.get(i).getPoint();
            accumulatedPoints[i] = accumulatedPoint;
        }
        return accumulatedPoints;
    }
}
