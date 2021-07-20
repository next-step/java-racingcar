package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    public List<Car> createCars(int number) {
        List<Car> cars = new ArrayList<>();
        for(int i=0; i<number; i++){
            cars.add(new Car());
        }
        return cars;
    }

}
