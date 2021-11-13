package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarGroup {

    private final int RANDOM_MAX_INT_VALUE = 10;
    private List<Car> cars = new ArrayList<>();

    public CarGroup(int count) {
        makeCars(count);
    }

    private void makeCars(int count) {
        for (int i = 0; i < count; i++) {
            cars.add(new Car());
        }
    }

    public void racing() {
        Random random = new Random();
        for (Car car : cars) {
            car.move(random.nextInt(RANDOM_MAX_INT_VALUE));
        }
        ResultView.result(cars);
    }
}
