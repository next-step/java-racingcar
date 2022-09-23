package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRacing {
    public List<Car> cars = new ArrayList<>();

    public CarRacing(int carCount) {
        participate(carCount);
    }

    public int carsCount() {
        return cars.size();
    }

    private void participate(int carCount) {
        cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }
}
