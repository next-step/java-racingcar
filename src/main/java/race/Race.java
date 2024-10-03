package race;

import java.util.ArrayList;
import java.util.List;

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
        System.out.println("cars = " + cars);
        System.out.println("round = " + round);
    }

}
