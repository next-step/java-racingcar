package game.race;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Car {

    private static final int THRESHOLD = 4;

    private String name;
    private int moveCount;

    public int getMoveCount() {
        return moveCount;
    }

    public void move() {
        int number = new Random().nextInt(10);
        moveCount += (number > THRESHOLD) ? number : 0;
    }

    public static List<Car> getCars(int vehicleCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < vehicleCount; i++) {
            cars.add(new Car());
        }
        return cars;
    }
}
