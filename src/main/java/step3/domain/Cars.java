package step3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Cars {

    private List<Car> cars = new ArrayList<>();

    public List<Car> getCars() {
        return cars;
    }

    public void carRegistration(int count) {
        cars = Stream.generate(Car::new)
                .limit(count)
                .collect(toList());
    }
}
