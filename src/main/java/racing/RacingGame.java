package racing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGame {
    private int time;
    private ArrayList<Car> cars;

    public RacingGame() {

    }

    public int getNumOfCars() {
        return cars.size();
    }

    public void setNumOfCars(int numberOfCars) {
        cars = new ArrayList<>(numberOfCars);

        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }
    }

    public int getNumOfMove() {
        return this.time;
    }

    public void setNumOfMove(int numberOfMoves) {
        this.time = numberOfMoves;
    }

    public List<Integer> move() {
        // TODO 구현
        return Collections.emptyList();
    }

}

class Car {
    public int position;

    public Car() {
        position = 0;
    }
}