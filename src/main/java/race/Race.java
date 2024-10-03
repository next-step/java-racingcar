package race;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Race {
    private final List<Car> cars = new ArrayList<>();
    private final int round;

    public Race(int carCount, int roundCount) {
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car(i));
        }

        this.round = roundCount;
    }

    public void run() {
        Random random = new Random();
        for (int i = 0; i < round; i++) {
            cars.forEach(car -> car.accelerate(random.nextInt(10)));
        }

        System.out.println("cars = " + cars);
    }

}
