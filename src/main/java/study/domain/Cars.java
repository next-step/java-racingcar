package study.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars = new ArrayList<>();

    public Cars(int count, int move) {
        for(int i=0; i < count; i++){
            cars.add(createCar(move));
        }
    }

    private Car createCar(int move) {
        Car car = new Car(move);
        return car;
    }

    public List<Car> getCars() {
        return cars;
    }
}
