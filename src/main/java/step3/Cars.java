package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {
    List<Car> cars;

    public Cars(int n) {
        this.cars = new ArrayList<>();
        for (int i=0; i<n; i++) {
            cars.add(new Car());
        }
    }

    public void playGame() {
        for (Car car : this.cars) {
            car.play(new Random());
        }
    }
}
