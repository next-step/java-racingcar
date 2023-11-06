package game.race;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Car {

    private static final int THRESHOLD = 4;

    private int cars;

    public List<Boolean> goForward() {
        List<Boolean> movements = new ArrayList<>();
        for (int car = 0; car < cars; car++) {
            int number = new Random().nextInt(10);
            movements.add(THRESHOLD < number);
        }

        return movements;
    }

    public void setCars(int cars) {
        this.cars = cars;
    }
}
