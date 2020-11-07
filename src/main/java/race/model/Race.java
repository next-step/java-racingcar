package race.model;

import race.strategy.MoveStrategy;
import race.strategy.RandomMoveStrategy;

import java.util.ArrayList;

public class Race {
    public interface RaceInterface {
        void getPosition(int position);
        void finishTurn();
    }

    private final ArrayList<Car> cars;
    private final MoveStrategy moveStrategy = new RandomMoveStrategy();

    public Race(int carCount) {
        cars = CarMaker.generate(carCount);
    }

    public void run(int runCount, RaceInterface raceInterface) {
        for (int i = 0; i < runCount; i++) {
            runForEachCar(raceInterface);

            raceInterface.finishTurn();
        }
    }

    private void runForEachCar(RaceInterface raceInterface) {
        for (Car car : cars) {
            car.move(moveStrategy.isMovable());

            raceInterface.getPosition(car.position);
        }
    }
}
