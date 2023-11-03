package study.racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {

    private final List<Car> carList = new ArrayList<>();

    public Cars(int count) {
        for(int i = 0; i < count; i++){
            carList.add(new Car(new RandomGenerator(new Random())));
        }
    }

    public int numberOfCar() {
        return carList.size();
    }
}
