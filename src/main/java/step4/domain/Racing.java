package step4.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {

    private final int MOVE_NUMBER = 4;
    private final String COMMA = ",";

    public List<Car> initCars(String[] names) {
        List<Car> cars = new ArrayList<>();

        for(int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i], MOVE_NUMBER));
        }

        return cars;
    }

    public String[] splitNames(String names) {
        return names.split(COMMA);
    }

    public void startRace(List<Car> cars) {
        Random random = new Random();

        for(Car car : cars) {
            car.move(random.nextInt(10));
        }
    }

}
