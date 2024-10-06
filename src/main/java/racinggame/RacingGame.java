package racinggame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racinggame.Car.CarDto;

public class RacingGame {

    private final List<List<CarDto>> snapShot;
    private Cars cars;

    public RacingGame(int carCount) {
        this.cars = Cars.of(carCount);
        this.snapShot = new ArrayList<>();
    }

    public void start(List<List<Integer>> repeatAndCapacities) {
        for (List<Integer> capacities : repeatAndCapacities) {
            moveAll(capacities);
            snapShot.add(cars.result());
        }
    }

    private void moveAll(List<Integer> capacities) {
        for (int i = 0; i < capacities.size(); i++) {
            cars.mode(i, capacities.get(i));
        }
    }

    public SnapShot matchResult() {
        return new SnapShot(snapShot);
    }

    public static class SnapShot {

        private final List<List<CarDto>> snapShot;

        public SnapShot(List<List<CarDto>> snapShot) {
            this.snapShot = snapShot;
        }

        public List<CarDto> getSnapShot(int index) {
            return Collections.unmodifiableList(snapShot.get(index));
        }

        public int repeatCount() {
            return snapShot.size();
        }
    }
}
