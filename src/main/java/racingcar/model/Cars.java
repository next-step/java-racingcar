package racingcar.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cars implements Iterable<Car> {

    private final List<Car> cars;

    public Cars(int tryNumber) {
        cars = new ArrayList<>();
        for (int i=0; i < tryNumber; i++) {
            cars.add(new Car());
        }
    }

    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }

    public RaceResult tryMove(int tryNumber, MoveStrategy moveStrategy) {
        RaceResult raceResult = new RaceResult();
        for (int i=0; i < tryNumber; i++) {
            orderMoveOneCycle(moveStrategy);
            raceResult.recordRaceResult(i, makeDistanceSnapShot());
        }
        return raceResult;
    }

    private void orderMoveOneCycle(MoveStrategy moveStrategy) {
        for (Car car : cars) {
            car.move(moveStrategy.getMoveNumber());
        }
    }

    private List<Integer> makeDistanceSnapShot() {
        List<Integer> distanceRecord = new ArrayList<>();
        for (Car car : cars) {
            distanceRecord.add(car.getDistance());
        }
        return distanceRecord;
    }
}
