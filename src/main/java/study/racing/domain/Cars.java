package study.racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {

    private static final int DEFAULT_POSITION = 1;
    private static final int RANDOM_RANGE = 10;
    private final List<Car> value;

    public Cars(CarsNumber carsNumber) {

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < carsNumber.getValue(); i++) {
            cars.add(new Car(new Position(DEFAULT_POSITION)));
        }

        this.value = cars;
    }

    public String move() {

        StringBuilder positionBuilder = new StringBuilder();
        Random random = new Random();
        for (Car car : value) {
            String dash = car.move(random.nextInt(RANDOM_RANGE));
            positionBuilder.append(dash);
        }
        return positionBuilder.toString();
    }
}
