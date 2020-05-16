package racingcar;

import java.util.List;

public class CarMover {

    public int[] move(List<Car> cars) {
        int[] carPositions = new int[cars.size()];

        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            int position = car.move();
            carPositions[i] = position;
        }

        return carPositions;
    }
}
