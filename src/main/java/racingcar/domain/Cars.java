package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {

    private List<Car> carList;

    public Cars(int carCount) {
        this.carList = Stream.generate(Car::new)
                .limit(carCount)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return carList;
    }

    public void move() {
        carList.forEach(Car::move);
    }
}
