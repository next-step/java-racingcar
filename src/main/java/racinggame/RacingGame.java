package racinggame;

import java.util.Collections;
import java.util.List;
import racinggame.Car.CarDto;
import racinggame.SnapShotStore.SnapShot;

public class RacingGame {

    private final SnapShotStore snapShotStore = new SnapShotStore();
    private Cars cars;

    public RacingGame(int carCount) {
        this.cars = Cars.of(carCount);
    }

    public void start(List<List<Integer>> repeatAndCapacities) {
        for (List<Integer> capacities : repeatAndCapacities) {
            moveAll(capacities);
            snapShotStore.save(cars.result());
        }
    }

    private void moveAll(List<Integer> capacities) {
        for (int i = 0; i < capacities.size(); i++) {
            cars.mode(i, capacities.get(i));
        }
    }

    public SnapShot matchResult() {
        return this.snapShotStore.snapShot();
    }
}
