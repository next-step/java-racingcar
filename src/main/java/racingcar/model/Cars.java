package racingcar.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cars implements Iterable<Car> {

    private final List<Car> cars;

    public Cars(CarNames carNames) {
        cars = new ArrayList<>();
        for (int carCount=0; carCount < carNames.getCarNameCount(); carCount++) {
            cars.add(new Car(carNames.getCarName(carCount)));
        }
    }

    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }

    public RaceResult tryMove(int tryNumber, MoveStrategy moveStrategy) {
        RaceResult raceResult = new RaceResult();

        for (int tryCount = 0; tryCount < tryNumber; tryCount++) {
            orderMoveOneCycle(moveStrategy);
            raceResult.recordRaceResult(tryCount, makeCarRecordSnapShot());
        }
        return raceResult;
    }

    private void orderMoveOneCycle(MoveStrategy moveStrategy) {
        cars.stream().forEach(car -> car.move(moveStrategy.getMoveNumber()));
    }

    private CarRecords makeCarRecordSnapShot() {
        CarRecords carRecords = new CarRecords();
        for (Car car : cars) {
            carRecords.add(new CarRecord(car.getName(), car.getDistance()));
        }
        return carRecords;
    }
}
