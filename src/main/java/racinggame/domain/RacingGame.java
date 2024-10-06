package racinggame.domain;

import java.util.List;
import racinggame.domain.SnapShotStore.SnapShot;
import racinggame.random.Radom;

public class RacingGame {

    private final SnapShotStore snapShotStore = new SnapShotStore();
    private Cars cars;
    private Integer repeatCount;

    public RacingGame(int repeatCount,int carCount) {
        this.repeatCount=repeatCount;
        this.cars = Cars.of(carCount);
    }


    public SnapShot start(Radom radom) {
        for(int i=0;i<repeatCount;i++){
            List<Integer> generate = radom.generate(cars.count());
            cars.move(generate);
            snapShotStore.save(cars.result());
        }
        return matchResult();
    }

    private SnapShot matchResult() {
        return this.snapShotStore.snapShot();
    }
}
