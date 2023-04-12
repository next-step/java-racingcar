package step3;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private final int raceCount;
    private final List<Car> cars;

    private Race(int raceCount, List<Car> cars) {
        this.raceCount = raceCount;
        this.cars = cars;
    }

    public static Race from(int raceCount, int carCount){
        List<Car> cars = new ArrayList<>(carCount);
        for(int i = 0; i < carCount; i++){
            cars.add(new Car());
        }

        return new Race(raceCount, cars);
    }

    public int getRaceCount() {
        return raceCount;
    }

    public List<Car> getCars() {
        return cars;
    }
}
