package step3.domain;

import step3.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class Racing {

    private final List<Car> car = new ArrayList<>();

    protected List<Car> carRegistration(int count) {
        for(int i = 0; i<count; i++)
            car.add(new Car());

        return car;
    }
}
