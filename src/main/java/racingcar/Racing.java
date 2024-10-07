package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {

    private static final Random RANDOM = new Random();

    private final List<Car> cars;

    public Racing(List<Car> cars) {
        this.cars = cars;
    }

    public List<Integer> play() {
        List<Integer> positions = new ArrayList();
        for (Car car : cars) {
            car.move(RANDOM.nextInt(10));
            positions.add(car.getCurrentPosition());
        }
        return positions;
    }

}
