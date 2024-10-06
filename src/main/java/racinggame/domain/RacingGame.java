package racinggame.domain;

import java.util.List;
import racinggame.domain.SnapShotStore.SnapShot;
import racinggame.random.Radom;

public class RacingGame {

    private final SnapShotStore snapShotStore = new SnapShotStore();
    private Cars cars;

    private Integer repeatCount;

    public RacingGame(int carCount,int repeatCount) {
        this.cars = Cars.of(carCount);
        this.repeatCount=repeatCount;
    }

    public SnapShot start(List<List<Integer>> repeatAndCapacities) {
        for (List<Integer> capacities : repeatAndCapacities) {
            moveAll(capacities);
            snapShotStore.save(cars.result());
        }
        return matchResult();
    }

    public SnapShot start(Radom radom) {
       return start(radom.generate(repeatCount,cars.count()));
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
