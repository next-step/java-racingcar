package step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Racing {

    private final List<Car> car = new ArrayList<>();
    public static int INPUT_NUMBER_OF_MOVE = 0;

    private int randomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

    protected List<Car> carRegistration(int count) {
        for(int i = 0; i<count; i++)
            car.add(new Car());

        return car;
    }

    public List<Car> carsMove(List<Car> car) {
        car.forEach(s -> s.move(randomNumber()));
        return car;
    }

    public int numberOfCarMove(Car car) {
        for(int i = 0; i< INPUT_NUMBER_OF_MOVE; i++)
            carsMove(Collections.singletonList(car));
        return car.getPosition();
    }
}
