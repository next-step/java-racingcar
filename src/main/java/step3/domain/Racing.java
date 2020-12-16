package step3.domain;

import step3.domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {

    private final List<Car> car = new ArrayList<>();

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
}
