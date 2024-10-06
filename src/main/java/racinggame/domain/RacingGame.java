package racinggame.domain;

import java.util.List;
import racinggame.domain.SnapShotStore.SnapShot;

public class RacingGame {

    private final SnapShotStore snapShotStore = new SnapShotStore();
    private Cars cars;

    public RacingGame(int carCount) {
        this.cars = Cars.of(carCount);
    }

    public SnapShot start(List<List<Integer>> repeatAndCapacities) {
        for (List<Integer> capacities : repeatAndCapacities) {
            moveAll(capacities);
            snapShotStore.save(cars.result());
        }
        return matchResult();
    }

    private void moveAll(List<Integer> capacities) {
        for (int i = 0; i < capacities.size(); i++) {
            cars.move(i, capacities.get(i));
        }
    }

//    public SnapShot matchResult() {
//        return this.snapShotStore.snapShot();
//    }
    private SnapShot matchResult() {
        return this.snapShotStore.snapShot();
    }
}
