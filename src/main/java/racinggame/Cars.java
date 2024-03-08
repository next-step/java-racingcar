package racinggame;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;
    private final int raceCount;

    public Cars(int carCount, int raceCount) {
        this.cars = initialCars(carCount);
        this.raceCount = raceCount;
    }

    private static List<Car> initialCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        for(int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    public void raceStart() {
        for(int i = 0; i < raceCount; i++) {
            cars.get(i).run(new MoveCondition());
        }
    }

    public List<Car> getRaceResult() {
        return cars;
    }
}
