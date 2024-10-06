package racinggame;

import java.util.List;
import java.util.Random;

public class RacingGame {

    private Cars cars;

    public RacingGame(int carCount) {
        this.cars = Cars.of(carCount);
    }

    public void start(List<List<Integer>> repeatAndCapacities) {
        for(List<Integer> capacities:repeatAndCapacities){
            moveAll(capacities);
        }
    }

    private void moveAll(List<Integer> capacities) {
        for(int i=0;i<capacities.size();i++){
            cars.mode(i,capacities.get(i));
        }
    }

    public Cars getCars() {
        return cars;
    }
}
