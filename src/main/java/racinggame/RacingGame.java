package racinggame;

import java.util.ArrayList;
import java.util.List;
import racinggame.Car.CarDto;

public class RacingGame {

    private Cars cars;
    private List<List<CarDto>> snapShot;

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

    public List<List<CarDto>> matchResult() {
        return snapShot;
    }

}
