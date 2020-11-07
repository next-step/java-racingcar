package race.model;

import java.util.ArrayList;

public class CarMaker {
    public static ArrayList<Car> generate(int carCount) {
        ArrayList<Car> cars = new ArrayList<>();

        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        return cars;
    }
}
