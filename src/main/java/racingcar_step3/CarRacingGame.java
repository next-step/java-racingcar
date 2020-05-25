package racingcar_step3;

import java.util.ArrayList;
import java.util.List;

public class CarRacingGame {

    private List<Integer> racingPositions = new ArrayList<>();

    public CarRacingGame() {
    }

    public List<Integer> createCars(int racingCarCount) {
        for (int i = 0; i < racingCarCount; i++) {
            racingPositions.add(0);
        }
        return racingPositions;
    }

    public List<Integer> runRacing(List<Integer> cars) {
        for(int i = 0; i < cars.size(); i++) {
            cars.set(i, Car.move(cars.get(i)));
        }
        return cars;
    }
}
